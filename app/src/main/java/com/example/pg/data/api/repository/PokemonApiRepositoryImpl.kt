package com.example.pg.data.api.repository

import com.example.pg.data.api.mappers.PokemonApiResponseMappers
import com.example.pg.data.api.service.PokemonApiService
import com.example.pg.domain.entity.PokemonEntity
import com.example.pg.domain.entity.PokemonListEntity
import com.example.pg.domain.repository.PokemonApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonApiRepositoryImpl(
    private val remoteSource: PokemonApiService,
    private val pokemonApiResponseMappers: PokemonApiResponseMappers
): PokemonApiRepository {
    override suspend fun getPokemonList(offset: Int, limit: Int): PokemonListEntity {
        return withContext(Dispatchers.IO) {
            (pokemonApiResponseMappers::mapPokemonListResponse)(remoteSource.getPokemonList(
                offset = offset, limit = limit
            ))
        }
    }

    override suspend fun getPokemonByName(name: String): PokemonEntity {
        return withContext(Dispatchers.IO) {
            (pokemonApiResponseMappers::mapPokemonResponse)(remoteSource.getPokemonByName(
                pokemonName = name
            ))
        }
    }
}