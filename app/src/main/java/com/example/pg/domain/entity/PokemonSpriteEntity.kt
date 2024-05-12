package com.example.pg.domain.entity

import com.example.pg.ui.model.PokemonSpriteDataModel

data class PokemonSpriteEntity(
    val backDefault: String,
    val backFemale: String,
    val backShiny: String,
    val backShinyFemale: String,
    val frontDefault: String,
    val frontFemale: String,
    val frontShiny: String,
    val frontShinyFemale: String,
    val other: OtherEntity,
)

fun PokemonSpriteEntity.mapPokemonSpriteEntity(): PokemonSpriteDataModel {
    return PokemonSpriteDataModel(
        backDefault = backDefault,
        backFemale = backFemale,
        backShiny = backShiny,
        backShinyFemale = backShinyFemale,
        frontDefault = frontDefault,
        frontFemale = frontFemale,
        frontShiny = frontShiny,
        frontShinyFemale = frontShinyFemale,
        other = other.mapOtherEntity()
    )
}
