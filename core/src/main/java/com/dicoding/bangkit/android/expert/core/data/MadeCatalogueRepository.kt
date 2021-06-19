package com.dicoding.bangkit.android.expert.core.data

import com.dicoding.bangkit.android.expert.core.data.source.local.MadeCatalogueLocalDataSource
import com.dicoding.bangkit.android.expert.core.data.source.remote.MadeCatalogueRemoteDataSource
import com.dicoding.bangkit.android.expert.core.data.source.remote.network.ApiResponse
import com.dicoding.bangkit.android.expert.core.data.source.remote.response.MadeCatalogueResponse
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue
import com.dicoding.bangkit.android.expert.core.domain.repository.IMadeCatalogueRepository
import com.dicoding.bangkit.android.expert.core.utils.AppExecutors
import com.dicoding.bangkit.android.expert.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MadeCatalogueRepository(
    private val madeCatalogueRemoteDataSource: MadeCatalogueRemoteDataSource,
    private val madeCatalogueLocalDataSource: MadeCatalogueLocalDataSource,
    private val appExecutors: AppExecutors
): IMadeCatalogueRepository {
//    companion object {
//        @Volatile
//        private var instance: MadeCatalogueRepository? = null
//
//        fun getInstance(
//            remoteData: MadeCatalogueRemoteDataSource,
//            localData: MadeCatalogueLocalDataSource,
//            appExecutors: AppExecutors
//        ): MadeCatalogueRepository =
//            instance ?: synchronized(this) {
//                instance ?: MadeCatalogueRepository(remoteData, localData, appExecutors)
//            }
//    }

    override fun getAllMadeCatalogue(): Flow<Resource<List<MadeCatalogue>>> =
        object : NetworkBoundResource<List<MadeCatalogue>, List<MadeCatalogueResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<MadeCatalogue>> {
//                return madeCatalogueLocalDataSource.getAllMadeCatalogue()
//                return Transformations.map(madeCatalogueLocalDataSource.getAllMadeCatalogue()){
//                    DataMapper.mapEntitiesToDomain(it)
//                }
                return madeCatalogueLocalDataSource.getAllMadeCatalogue().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MadeCatalogue>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MadeCatalogueResponse>>> {
                return madeCatalogueRemoteDataSource.getAllMadeCatalogue()
            }

            override suspend fun saveCallResult(data: List<MadeCatalogueResponse>) {
                val madeCatalogueList = DataMapper.mapResponsesToEntities(data)
                madeCatalogueLocalDataSource.insertMadeCatalogue(madeCatalogueList)
            }
        }.asFlow()


    override fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogue>> {
//        return madeCatalogueLocalDataSource.getFavoriteMadeCatalogue()
//        return Transformations.map(madeCatalogueLocalDataSource.getFavoriteMadeCatalogue()){
//            DataMapper.mapEntitiesToDomain(it)
        return madeCatalogueLocalDataSource.getFavoriteMadeCatalogue().map {
            DataMapper.mapEntitiesToDomain(it)
        }

    }

    override fun setFavoriteMadeCatalogue(madecatalogue: MadeCatalogue, state: Boolean) {
        val madecatalogueEntity = DataMapper.mapDomainToEntity(madecatalogue)
        appExecutors.diskIO().execute { madeCatalogueLocalDataSource.setFavoriteMadeCatalogue(madecatalogueEntity, state) }
    }
}


