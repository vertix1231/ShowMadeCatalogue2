package com.dicoding.bangkit.android.expert.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dicoding.bangkit.android.expert.core.BuildConfig
import kotlinx.android.parcel.Parcelize



@Parcelize
@Entity(tableName = BuildConfig.TABLE_NAME)
data class MadeCatalogueEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tourismId")
    var Id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "playtime")
    var playtime: Double,

    @ColumnInfo(name = "metacritic")
    var metacritic: Double,

    @ColumnInfo(name = "ratings_count")
    var ratings_count: Int,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

//    @PrimaryKey
//    @NonNull
//    @ColumnInfo(name = "tourismId")
//    var tourismId: String,
//
//    @ColumnInfo(name = "name")
//    var name: String,
//
//    @ColumnInfo(name = "description")
//    var description: String,
//
//    @ColumnInfo(name = "address")
//    var address: String,
//
//    @ColumnInfo(name = "latitude")
//    var latitude: Double,
//
//    @ColumnInfo(name = "longitude")
//    var longitude: Double,
//
//    @ColumnInfo(name = "like")
//    var like: Int,
//
//    @ColumnInfo(name = "image")
//    var image: String,
//
//    @ColumnInfo(name = "isFavorite")
//    var isFavorite: Boolean = false

): Parcelable
