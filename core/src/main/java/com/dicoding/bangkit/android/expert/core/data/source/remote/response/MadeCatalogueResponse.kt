package com.dicoding.bangkit.android.expert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MadeCatalogueResponse(

    @SerializedName("id")
    val Id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("released")
    val released: String,

    @SerializedName("rating")
    val rating: String,

    @SerializedName("playtime")
    val playtime: Double,

    @SerializedName("metacritic")
    val metacritic: Double,

    @SerializedName("ratings_count")
    val ratings_count: Int,

    @SerializedName("background_image")
    val image: String

//    @SerializedName("id")
//    val id: String,
//
//    @SerializedName("name")
//    val name: String,
//
//    @SerializedName("released")
//    val description: String,
//
//    @SerializedName("rating")
//    val address: String,
//
//    @SerializedName("playtime")
//    val longitude: Double,
//
//    @SerializedName("metacritic")
//    val latitude: Double,
//
//    @SerializedName("ratings_count")
//    val like: Int,
//
//    @SerializedName("background_image")
//    val image: String






//    @SerializedName("id")
//    val id: String,
//
//    @SerializedName("name")
//    val name: String,
//
//    @SerializedName("description")
//    val description: String,
//
//    @SerializedName("address")
//    val address: String,
//
//    @SerializedName("longitude")
//    val longitude: Double,
//
//    @SerializedName("latitude")
//    val latitude: Double,
//
//    @SerializedName("like")
//    val like: Int,
//
//    @SerializedName("image")
//    val image: String
)

