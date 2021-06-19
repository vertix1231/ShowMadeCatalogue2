package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.di

import com.dicoding.bangkit.android.expert.core.domain.usecase.MadeCatalogueInteractor
import com.dicoding.bangkit.android.expert.core.domain.usecase.MadeCatalogueUseCase
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail.DetailViewModel
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.favorite.FavoriteViewModel
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MadeCatalogueUseCase> { MadeCatalogueInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}