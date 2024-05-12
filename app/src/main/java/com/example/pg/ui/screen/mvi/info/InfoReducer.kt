package com.example.pg.ui.screen.mvi.info

import com.example.pg.ui.model.PokemonDataModel
import com.example.pg.ui.mvi.MviReducer
import com.example.pg.ui.utils.LceState

class InfoReducer : MviReducer<InfoPartialState, InfoState> {
    override fun reduce(prevState: InfoState, partialState: InfoPartialState): InfoState {
        return when (partialState) {
            is InfoPartialState.DataLoaded -> updatePageInState(
                prevState,
                partialState.pokemonDataModel,
            )
        }
    }

    private fun updatePageInState(
        prevState: InfoState,
        pokemonDataModel: PokemonDataModel,
    ): InfoState {
        return prevState.copy(
            pokemonDataModel = LceState.Content(pokemonDataModel),
        )
    }
}