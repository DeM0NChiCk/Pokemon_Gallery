package com.example.pg.ui.model

data class PokemonDataModel(
    val name: String,
    val weight: Int,
    val height: Int,
    val baseExperience: Int,
    val abilities: List<PokemonAbilityDataModel>,
    val stats: List<PokemonStatsDataModel>,
    val sprites: PokemonSpriteDataModel,
    val types: List<PokemonTypeDataModel>,
)
