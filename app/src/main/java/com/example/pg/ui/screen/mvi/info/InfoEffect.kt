package com.example.pg.ui.screen.mvi.info

import com.example.pg.ui.mvi.MviEffect

sealed interface InfoEffect: MviEffect {
    data class ShowError(val throwable: Throwable): InfoEffect
    data class ShowShimmer(val boolean: Boolean): InfoEffect
}