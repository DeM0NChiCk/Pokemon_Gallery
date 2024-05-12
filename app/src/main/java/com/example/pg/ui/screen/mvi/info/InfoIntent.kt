package com.example.pg.ui.screen.mvi.info

import com.example.pg.ui.mvi.MviIntent

sealed interface InfoIntent: MviIntent {
    data class Init(val name: String): InfoIntent
}