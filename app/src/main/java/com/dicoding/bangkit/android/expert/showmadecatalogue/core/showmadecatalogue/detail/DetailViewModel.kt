package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail

import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import com.dicoding.bangkit.android.expert.core.domain.usecase.MadeCatalogueUseCase

class DetailViewModel(private val madeCatalogueUseCase: MadeCatalogueUseCase) : ViewModel() {
    fun setFavorite(madeCatalogue: MadeCatalogue, newStatus:Boolean) = madeCatalogueUseCase.setFavoriteMadeCatalogue(madeCatalogue, newStatus)
}

