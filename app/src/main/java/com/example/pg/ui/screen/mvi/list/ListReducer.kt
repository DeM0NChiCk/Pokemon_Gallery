package com.example.pg.ui.screen.mvi.list

import com.example.pg.ui.model.PokemonListDataModel
import com.example.pg.ui.mvi.MviReducer
import com.example.pg.ui.utils.LceState

class ListReducer : MviReducer<ListPartialState, ListState> {
    override fun reduce(prevState: ListState, partialState: ListPartialState): ListState {
        return when (partialState) {
            is ListPartialState.NextPageLoaded -> updatePageInState(
                prevState,
                partialState.offset,
                partialState.limit,
                partialState.pokemonListDataModelUi
            )
        }
    }

    private fun updatePageInState(
        prevState: ListState,
        offset: Int,
        limit: Int,
        pokemonListDataModel: PokemonListDataModel
    ): ListState {
        return prevState.copy(
            pokemonListDataModel = LceState.Content(pokemonListDataModel),
            offset = offset,
            limit = limit
            )
    }

}