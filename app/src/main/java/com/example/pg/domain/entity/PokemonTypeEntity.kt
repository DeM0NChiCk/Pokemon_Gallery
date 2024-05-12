package com.example.pg.domain.entity

import com.example.pg.ui.model.PokemonTypeDataModel

data class PokemonTypeEntity(
    val slot: Int,
    val type: ResultEntity
)

fun PokemonTypeEntity.mapPokemonTypeEntity(): PokemonTypeDataModel {
    return PokemonTypeDataModel(
        slot = slot,
        type = type.mapResultEntity()
    )
}
