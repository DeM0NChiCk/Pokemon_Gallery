package com.example.pg.ui.screen.mvi.list

import com.example.pg.ui.model.PokemonListDataModel
import com.example.pg.ui.mvi.MviPartialState

sealed interface ListPartialState: MviPartialState {
    data class NextPageLoaded(
        val pokemonListDataModelUi: PokemonListDataModel,
        val offset: Int,
        val limit: Int,
    ): ListPartialState
}