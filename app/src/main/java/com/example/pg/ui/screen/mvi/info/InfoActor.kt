package com.example.pg.ui.screen.mvi.info

import com.example.pg.domain.usecase.GetPokemonByName
import com.example.pg.ui.mvi.MviActor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InfoActor (
    private val useCase: GetPokemonByName,
): MviActor<InfoPartialState, InfoIntent, InfoState, InfoEffect>() {
    override fun resolve(intent: InfoIntent, state: InfoState): Flow<InfoPartialState> {
        return when(intent) {
            is InfoIntent.Init -> loadData(intent.name)
        }
    }

    private fun loadData(
        name: String,
    ): Flow<InfoPartialState> {
        return flow {
            runCatching {
                useCase.invoke(name)
            }.fold(
                onSuccess = {
                    emit(InfoPartialState.DataLoaded(it, name))
                },
                onFailure = {
                    _effects.emit(InfoEffect.ShowError(it))
                }
            )
        }
    }
}