package com.dicoding.bangkit.android.expert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(

    @field:SerializedName("places")
	val places: List<PlacesItem?>? = null,

    @field:SerializedName("count")
	val count: Int? = null,

    @field:SerializedName("error")
	val error: Boolean? = null,

    @field:SerializedName("message")
	val message: String? = null
)

data class PlacesItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("like")
	val like: Int? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null
)
