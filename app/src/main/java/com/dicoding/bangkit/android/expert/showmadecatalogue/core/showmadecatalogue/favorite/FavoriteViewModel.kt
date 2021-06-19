package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.bangkit.android.expert.core.domain.usecase.MadeCatalogueUseCase

class FavoriteViewModel(madeCatalogueUseCase: MadeCatalogueUseCase) : ViewModel() {

    val favoriteMadeCatalogue = madeCatalogueUseCase.getFavoriteMadeCatalogue().asLiveData()

}

