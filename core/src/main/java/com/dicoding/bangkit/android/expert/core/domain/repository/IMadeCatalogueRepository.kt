package com.dicoding.bangkit.android.expert.core.domain.repository

import com.dicoding.bangkit.android.expert.core.data.Resource
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import kotlinx.coroutines.flow.Flow

interface IMadeCatalogueRepository {

    fun getAllMadeCatalogue(): Flow<Resource<List<MadeCatalogue>>>

    fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogue>>

    fun setFavoriteMadeCatalogue(tourism: MadeCatalogue, state: Boolean)
}