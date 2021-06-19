package com.dicoding.bangkit.android.expert.core.data.source.local

import com.dicoding.bangkit.android.expert.core.data.source.local.entity.MadeCatalogueEntity
import com.dicoding.bangkit.android.expert.core.data.source.local.room.MadeCatalogueDao
import kotlinx.coroutines.flow.Flow

class MadeCatalogueLocalDataSource(private val madeCatalogueDao: MadeCatalogueDao){

//    companion object{
//        private var instance: MadeCatalogueLocalDataSource? = null
//
//        fun getInstance(madeCatalogueDao: MadeCatalogueDao): MadeCatalogueLocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: MadeCatalogueLocalDataSource(madeCatalogueDao)
//            }
//    }

    fun getAllMadeCatalogue(): Flow<List<MadeCatalogueEntity>> = madeCatalogueDao.getAllMadeCatalogue()

    fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogueEntity>> = madeCatalogueDao.getFavoriteMadeCatalogue()

    suspend fun insertMadeCatalogue(tourismList: List<MadeCatalogueEntity>) = madeCatalogueDao.insertMadeCatalogue(tourismList)

    fun setFavoriteMadeCatalogue(tourism: MadeCatalogueEntity, newState: Boolean) {
        tourism.isFavorite = newState
        madeCatalogueDao.updateFavoriteMadeCatalogue(tourism)
    }
}