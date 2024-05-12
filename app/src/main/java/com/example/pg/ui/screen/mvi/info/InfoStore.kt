package com.example.pg.ui.screen.mvi.info

import com.example.pg.ui.mvi.MviStore
import com.example.pg.ui.utils.LceState

class InfoStore (
    reducer: InfoReducer,
    actor: InfoActor,
): MviStore<InfoPartialState, InfoIntent, InfoState, InfoEffect>(
    reducer,
    actor
){
    override fun initialStateCreator(): InfoState = InfoState(
        pokemonDataModel = LceState.Loading,
    )
}