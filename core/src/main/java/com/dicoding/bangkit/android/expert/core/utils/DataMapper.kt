package com.dicoding.bangkit.android.expert.core.utils

import com.dicoding.bangkit.android.expert.core.data.source.local.entity.MadeCatalogueEntity
import com.dicoding.bangkit.android.expert.core.data.source.remote.response.MadeCatalogueResponse
import com.dicoding.bangkit.android.expert.core.domain.model.MadeCatalogue

object DataMapper {
    fun mapResponsesToEntities(input: List<MadeCatalogueResponse>): List<MadeCatalogueEntity> {
        val tourismList = ArrayList<MadeCatalogueEntity>()
        input.map {
            val tourism = MadeCatalogueEntity(
                Id = it.Id,
                name = it.name,
                released = it.released,
                rating = it.rating,
                playtime = it.playtime,
                metacritic = it.metacritic,
                ratings_count = it.ratings_count,
                image = it.image,
                isFavorite = false,

//                tourismId = it.id,
//                description = it.description,
//                name = it.name,
//                address = it.address,
//                latitude = it.latitude,
//                longitude = it.longitude,
//                like = it.like,
//                image = it.image,
//                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    // UBAH ROOM ENTITY MADECATALOGUE JADI MODEL DOMAIN MADECATALOGUE

    fun mapEntitiesToDomain(input: List<MadeCatalogueEntity>): List<MadeCatalogue> =
        input.map {
            MadeCatalogue(
                Id = it.Id,
                name = it.name,
                released = it.released,
                rating = it.rating,
                playtime = it.playtime,
                metacritic = it.metacritic,
                ratings_count = it.ratings_count,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: MadeCatalogue) = MadeCatalogueEntity(
        Id = input.Id,
        name = input.name,
        released = input.released,
        rating = input.rating,
        playtime = input.playtime,
        metacritic = input.metacritic,
        ratings_count = input.ratings_count,
        image = input.image,
        isFavorite = input.isFavorite
    )
}