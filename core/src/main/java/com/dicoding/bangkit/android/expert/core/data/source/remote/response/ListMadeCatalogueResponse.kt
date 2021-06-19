package com.dicoding.bangkit.android.expert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMadeCatalogueResponse(

    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: String,

    @SerializedName("results")
    val places:List<MadeCatalogueResponse>
//    @SerializedName("error")
//    val error:Boolean,
//
//    @SerializedName("message")
//    val message:String,
//
//    @SerializedName("places")
//    val places:List<MadeCatalogueResponse>
)
