package com.dicoding.bangkit.android.expert.core.data.source.local.room

import androidx.room.*
import com.dicoding.bangkit.android.expert.core.BuildConfig
import com.dicoding.bangkit.android.expert.core.data.source.local.entity.MadeCatalogueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MadeCatalogueDao {
    @Query("SELECT * FROM ${BuildConfig.TABLE_NAME}")
    fun getAllMadeCatalogue(): Flow<List<MadeCatalogueEntity>>

    @Query("SELECT * FROM ${BuildConfig.TABLE_NAME} where isFavorite = 1")
    fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogueEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMadeCatalogue(tourism: List<MadeCatalogueEntity>)

    @Update
    fun updateFavoriteMadeCatalogue(madeCatalogueEntity: MadeCatalogueEntity)

}