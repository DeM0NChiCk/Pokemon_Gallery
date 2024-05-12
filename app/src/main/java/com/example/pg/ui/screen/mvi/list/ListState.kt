package com.example.pg.ui.screen.mvi.list

import com.example.pg.ui.enums.ConstValue.LIMIT
import com.example.pg.ui.model.PokemonListDataModel
import com.example.pg.ui.mvi.MviState
import com.example.pg.ui.utils.LceState

data class ListState (
    val pokemonListDataModel: LceState<PokemonListDataModel>,
    val offset: Int = 0,
    val limit: Int = LIMIT,
) : MviState