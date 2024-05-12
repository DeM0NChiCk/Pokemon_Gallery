package com.example.pg.ui.screen.mvi.list

import com.example.pg.domain.usecase.GetPokemonListUseCase
import com.example.pg.ui.enums.ConstValue.LIMIT
import com.example.pg.ui.mvi.MviActor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListActor(
    private val useCase: GetPokemonListUseCase,
) : MviActor<ListPartialState, ListIntent, ListState, ListEffect>() {
    override fun resolve(intent: ListIntent, state: ListState): Flow<ListPartialState> {
        return when (intent) {
            ListIntent.Init -> pageLoadData(0, LIMIT)
            ListIntent.NextPage -> pageLoadData(state.offset + LIMIT, LIMIT)
            ListIntent.PreviousPage -> pageLoadData(state.offset - LIMIT, LIMIT)
        }
    }

    private fun pageLoadData(
        offset: Int,
        limit: Int,
    ): Flow<ListPartialState> {
        return flow {
            runCatching {
                useCase.invoke(offset, limit)
            }.fold(
                onSuccess = {
                    emit(ListPartialState.NextPageLoaded(it, offset, limit))
                },
                onFailure = {
                    _effects.emit(ListEffect.ShowError(it))
                }
            )
        }
    }

}