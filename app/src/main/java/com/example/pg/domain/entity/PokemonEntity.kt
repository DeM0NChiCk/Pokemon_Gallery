package com.example.pg.domain.entity

import com.example.pg.ui.model.PokemonDataModel

data class PokemonEntity (
    val name: String,
    val weight: Int,
    val height: Int,
    val baseExperience: Int,
    val abilities: List<PokemonAbilityEntity>,
    val stats: List<PokemonStatsEntity>,
    val sprites: PokemonSpriteEntity,
    val types: List<PokemonTypeEntity>,
)

fun PokemonEntity.mapPokemonEntity(): PokemonDataModel {
    return PokemonDataModel(
        name = name,
        weight = weight,
        height = height,
        baseExperience = baseExperience,
        abilities = abilities.map { it.mapPokemonAbilityEntity() },
        stats = stats.map { it.mapPokemonStatsEntity() },
        sprites = sprites.mapPokemonSpriteEntity(),
        types = types.map { it.mapPokemonTypeEntity() }
    )
}

