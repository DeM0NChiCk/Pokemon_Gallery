package com.example.pg.ui.model

data class PokemonListDataModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultDataModel>
)
