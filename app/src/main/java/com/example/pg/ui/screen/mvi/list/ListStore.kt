package com.example.pg.ui.screen.mvi.list

import com.example.pg.ui.mvi.MviStore
import com.example.pg.ui.utils.LceState

class ListStore(
    reducer: ListReducer,
    actor: ListActor
): MviStore<ListPartialState, ListIntent, ListState, ListEffect>(
    reducer,
    actor
){
    override fun initialStateCreator(): ListState = ListState(
        pokemonListDataModel = LceState.Loading
    )
}