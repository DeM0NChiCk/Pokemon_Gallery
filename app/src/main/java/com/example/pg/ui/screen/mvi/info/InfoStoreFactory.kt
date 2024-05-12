package com.example.pg.ui.screen.mvi.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InfoStoreFactory (
    private val reducer: InfoReducer,
    private val actor: InfoActor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfoStore(reducer, actor) as T
    }
}