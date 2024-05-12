package com.example.pg.ui.screen.mvi.list

import com.example.pg.ui.mvi.MviIntent

sealed interface ListIntent: MviIntent {
    data object Init: ListIntent
    data object NextPage : ListIntent
    data object PreviousPage : ListIntent
}