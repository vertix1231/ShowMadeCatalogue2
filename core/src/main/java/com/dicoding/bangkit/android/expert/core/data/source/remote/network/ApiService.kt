package com.dicoding.bangkit.android.expert.core.data.source.remote.network

import com.dicoding.bangkit.android.expert.core.data.source.remote.response.ListMadeCatalogueResponse
import retrofit2.http.GET

interface ApiService {
    companion object{
        const val TOKEN_KEY = "b791038295cf4d71930a98e13fea466a"
    }

    @GET("games?key=$TOKEN_KEY")
    suspend fun getListApi(): ListMadeCatalogueResponse
//    @GET("list")
//    suspend fun getListApi(): ListMadeCatalogueResponse
}