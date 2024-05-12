package com.example.pg.domain.entity

import com.example.pg.ui.model.PokemonStatsDataModel


data class PokemonStatsEntity(
    val baseStat: Int,
    val effort: Int,
    val stat: ResultEntity
)

fun PokemonStatsEntity.mapPokemonStatsEntity(): PokemonStatsDataModel {
    return PokemonStatsDataModel(
        baseStat = baseStat,
        effort = effort,
        stat = stat
    )
}

