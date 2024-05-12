package com.example.pg.domain.entity

import com.example.pg.ui.model.PokemonAbilityDataModel

data class PokemonAbilityEntity (
    val ability: ResultEntity,
    val isHidden: Boolean,
    val slot: Int
)

fun PokemonAbilityEntity.mapPokemonAbilityEntity(): PokemonAbilityDataModel {
    return PokemonAbilityDataModel(
        ability = ability.mapResultEntity(),
        isHidden = isHidden,
        slot = slot
    )
}