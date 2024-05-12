package com.example.pg.ui.model

import com.example.pg.domain.entity.ResultEntity

data class PokemonStatsDataModel(
    val baseStat: Int,
    val effort: Int,
    val stat: ResultEntity
)