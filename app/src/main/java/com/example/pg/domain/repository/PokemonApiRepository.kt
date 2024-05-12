package com.example.pg.domain.repository

import com.example.pg.domain.entity.PokemonEntity
import com.example.pg.domain.entity.PokemonListEntity

interface PokemonApiRepository {

    suspend fun getPokemonList(
        offset: Int,
        limit: Int
    ): PokemonListEntity

    suspend fun getPokemonByName(
        name: String
    ): PokemonEntity
}