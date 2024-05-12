package com.example.pg.ui.screen.mvi.info

import com.example.pg.ui.model.PokemonDataModel
import com.example.pg.ui.mvi.MviState
import com.example.pg.ui.utils.LceState

data class InfoState(
    val pokemonDataModel: LceState<PokemonDataModel>,
): MviState