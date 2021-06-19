package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue

import android.app.Application
import com.dicoding.bangkit.android.expert.core.di.databaseModule
import com.dicoding.bangkit.android.expert.core.di.networkModule
import com.dicoding.bangkit.android.expert.core.di.repositoryModule
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.di.useCaseModule
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}