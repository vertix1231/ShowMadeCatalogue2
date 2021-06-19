package com.dicoding.bangkit.android.expert.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.bangkit.android.expert.core.data.source.local.entity.MadeCatalogueEntity

@Database(entities = [MadeCatalogueEntity::class],version = 1,exportSchema = false)
abstract class MadeCatalogueDatabase: RoomDatabase() {

    abstract fun madeCatalogueDao(): MadeCatalogueDao

//    companion object{
//        @Volatile
//        private var INSTANCE : MadeCatalogueDatabase? = null
//
//        fun getInstance(context: Context): MadeCatalogueDatabase =
//            INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MadeCatalogueDatabase::class.java,
//                    "${BuildConfig.DATABASE_NAME}"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//    }
}