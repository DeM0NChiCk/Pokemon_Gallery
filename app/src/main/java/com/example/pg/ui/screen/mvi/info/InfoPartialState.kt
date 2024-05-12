package com.example.pg.ui.screen.mvi.info

import com.example.pg.ui.model.PokemonDataModel
import com.example.pg.ui.mvi.MviPartialState

sealed interface InfoPartialState: MviPartialState {
    data class DataLoaded(
        val pokemonDataModel: PokemonDataModel,
        val name: String
    ): InfoPartialState
}