package com.example.pg.ui.screen.mvi.list

import com.example.pg.ui.mvi.MviEffect

sealed interface ListEffect: MviEffect {
    data class ShowError(val throwable: Throwable): ListEffect
    data class ShowShimmer(val boolean: Boolean): ListEffect
}