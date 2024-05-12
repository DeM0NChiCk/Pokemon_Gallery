package com.example.pg.domain.entity

import com.example.pg.ui.model.ShowdownDataModel

data class ShowdownEntity(
    val backDefault: String,
    val backFemale: String,
    val backShiny: String,
    val backShinyFemale: String,
    val frontDefault: String,
    val frontFemale: String,
    val frontShiny: String,
    val frontShinyFemale: String,
)

fun ShowdownEntity.mapShowdownEntity() : ShowdownDataModel{
    return ShowdownDataModel(
        backDefault = backDefault,
        backFemale = backFemale,
        backShiny = backShiny,
        backShinyFemale = backShinyFemale,
        frontDefault = frontDefault,
        frontFemale = frontFemale,
        frontShiny = frontShiny,
        frontShinyFemale = frontShinyFemale
    )
}