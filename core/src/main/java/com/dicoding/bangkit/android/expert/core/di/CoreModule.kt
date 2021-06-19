package com.dicoding.bangkit.android.expert.core.di

import androidx.room.Room
import com.dicoding.bangkit.android.expert.core.BuildConfig
import com.dicoding.bangkit.android.expert.core.data.MadeCatalogueRepository
import com.dicoding.bangkit.android.expert.core.data.source.local.MadeCatalogueLocalDataSource
import com.dicoding.bangkit.android.expert.core.data.source.local.room.MadeCatalogueDatabase
import com.dicoding.bangkit.android.expert.core.data.source.remote.MadeCatalogueRemoteDataSource
import com.dicoding.bangkit.android.expert.core.data.source.remote.network.ApiService
import com.dicoding.bangkit.android.expert.core.domain.repository.IMadeCatalogueRepository
import com.dicoding.bangkit.android.expert.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MadeCatalogueDatabase>().madeCatalogueDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            MadeCatalogueDatabase::class.java, BuildConfig.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "api.rawg.io"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/RI9CUmPUOpUk2vdVMSZDWj+wtoQO5k9MSCSM9w4grmU=")
            .add(hostname,"sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
            .add(hostname,"sha256/Y9mvm0exBk1JoQ57f9Vm28jKo5lFm/woKcVxrYxu80o=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
//    single {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://tourism-api.dicoding.dev/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(get())
//            .build()
//        retrofit.create(ApiService::class.java)
//    }
}

val repositoryModule = module {
    single { MadeCatalogueLocalDataSource(get()) }
    single { MadeCatalogueRemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMadeCatalogueRepository> { MadeCatalogueRepository(get(), get(), get()) }
}

//berhasil
//    .add(hostname, "sha256/RI9CUmPUOpUk2vdVMSZDWj+wtoQO5k9MSCSM9w4grmU=")
//    .add(hostname,"sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
//    .add(hostname,"sha256/Y9mvm0exBk1JoQ57f9Vm28jKo5lFm/woKcVxrYxu80o=")

//gagal
//    .add(hostname, "sha256/+WSYXXW0rd5TnILDGuJvshU5aExcOMlLxvQBPOT4PS0=")