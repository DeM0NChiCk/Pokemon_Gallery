package com.example.pg.ui.mvi

interface MviReducer<PartialState: MviPartialState, State: MviState> {
    fun reduce(prevState: State, partialState: PartialState): State
}