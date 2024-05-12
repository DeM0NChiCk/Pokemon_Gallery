package com.example.pg.ui.screen.mvi.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListStoreFactory(
    private val reducer: ListReducer,
    private val actor: ListActor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListStore(reducer, actor) as T
    }
}