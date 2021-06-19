package com.dicoding.bangkit.android.expert.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.bangkit.android.expert.core.domain.usecase.MadeCatalogueUseCase

class FavoriteViewModel(madeCatalogueUseCase: MadeCatalogueUseCase):ViewModel() {
    val madecataluguefav = madeCatalogueUseCase.getFavoriteMadeCatalogue().asLiveData()
}