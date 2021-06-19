package com.dicoding.bangkit.android.expert.core.data.source.remote

import android.util.Log
import com.dicoding.bangkit.android.expert.core.data.source.remote.network.ApiResponse
import com.dicoding.bangkit.android.expert.core.data.source.remote.network.ApiService
import com.dicoding.bangkit.android.expert.core.data.source.remote.response.MadeCatalogueResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class MadeCatalogueRemoteDataSource(private val apiService: ApiService){

//    companion object {
//        @Volatile
//        private var instance: MadeCatalogueRemoteDataSource? = null
//
//        fun getInstance(helper: ApiService): MadeCatalogueRemoteDataSource =
//            instance ?: synchronized(this) {
//                instance ?: MadeCatalogueRemoteDataSource(helper)
//            }
//    }

    suspend fun getAllMadeCatalogue(): Flow<ApiResponse<List<MadeCatalogueResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListApi()
                val dataArray = response.places
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

//        val resultData = MutableLiveData<ApiResponse<List<MadeCatalogueResponse>>>()

//        //get data from remote api
//        val client = apiService.getListApi()
//        client.enqueue(object : Callback<ListMadeCatalogueResponse> {
//            override fun onResponse(
//                call: Call<ListMadeCatalogueResponse>,
//                response: Response<ListMadeCatalogueResponse>
//            ) {
//                val dataArray = response.body()?.places
//                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
//            }
//            override fun onFailure(call: Call<ListMadeCatalogueResponse>, t: Throwable) {
//                resultData.value = ApiResponse.Error(t.message.toString())
//                Log.e("RemoteDataSource", t.message.toString())
//            }
//        })
//
//        return resultData
//        val handler = Handler(Looper.getMainLooper())
//        handler.postDelayed({
//            try {
//                val dataArray = jsonHelper.loadData()
//                if (dataArray.isNotEmpty()) {
//                    resultData.value = ApiResponse.Success(dataArray)
//                } else {
//                    resultData.value = ApiResponse.Empty
//                }
//            } catch (e: JSONException){
//                resultData.value = ApiResponse.Error(e.toString())
//                Log.e("RemoteDataSource", e.toString())
//            }
//        }, 2000)
//
//        return resultData
    }
}
