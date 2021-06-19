package com.dicoding.bangkit.android.expert.core.domain.usecase

import com.dicoding.bangkit.android.expert.core.data.Resource
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import com.dicoding.bangkit.android.expert.core.domain.repository.IMadeCatalogueRepository
import kotlinx.coroutines.flow.Flow

class MadeCatalogueInteractor(private val imadeCatalogueRepository: IMadeCatalogueRepository):
    MadeCatalogueUseCase {
    override fun getAllMadeCatalogue(): Flow<Resource<List<MadeCatalogue>>> {
       return imadeCatalogueRepository.getAllMadeCatalogue()
    }

    override fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogue>> {
        return imadeCatalogueRepository.getFavoriteMadeCatalogue()
    }

    override fun setFavoriteMadeCatalogue(tourism: MadeCatalogue, state: Boolean) {
        return imadeCatalogueRepository.setFavoriteMadeCatalogue(tourism,state)
    }
}