package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.bangkit.android.expert.core.domain.usecase.MadeCatalogueUseCase

class HomeViewModel(madeCatalogueUseCase: MadeCatalogueUseCase) : ViewModel() {

    val madeCatalogue = madeCatalogueUseCase.getAllMadeCatalogue().asLiveData()

}

