package com.dicoding.bangkit.android.expert.core.ui

//class ViewModelFactory private constructor(private val madeCatalogueUseCase: MadeCatalogueUseCase) :
//    ViewModelProvider.NewInstanceFactory(){
//
//    companion object {
//        @Volatile
//        private var instance: ViewModelFactory? = null
//
//        fun getInstance(context: Context): ViewModelFactory =
//            instance
//                ?: synchronized(this) {
//                    instance
//                        ?: ViewModelFactory(
//                            Injection.provideMadeCatalogueUseCase(
//                                context
//                            )
//                        )
//                }
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        when {
//            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
//                HomeViewModel(madeCatalogueUseCase) as T
//            }
//            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
//                FavoriteViewModel(madeCatalogueUseCase) as T
//            }
//            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
//                DetailViewModel(madeCatalogueUseCase) as T
//            }
//            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
//        }
//}