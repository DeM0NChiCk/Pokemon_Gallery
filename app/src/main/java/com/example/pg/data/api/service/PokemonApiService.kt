package com.example.pg.data.api.service

import com.example.pg.data.api.model.response.PokemonListResponse
import com.example.pg.data.api.model.response.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonListResponse

    @GET("pokemon/{pokemonName}/")
    suspend fun getPokemonByName(
        @Path("pokemonName") pokemonName: String
    ): PokemonResponse
}