package com.example.pg.domain.entity

import com.example.pg.ui.model.PokemonListDataModel

data class PokemonListEntity (
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultEntity>
)

fun PokemonListEntity.mapPokemonListEntity(): PokemonListDataModel {
    return PokemonListDataModel(
        count = count,
        next = next,
        previous = previous,
        results = results.map { it.mapResultEntity() }
    )
}