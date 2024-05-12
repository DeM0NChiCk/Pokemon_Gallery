package com.example.pg.domain.usecase

import com.example.pg.domain.entity.mapPokemonEntity
import com.example.pg.domain.repository.PokemonApiRepository
import com.example.pg.ui.model.PokemonDataModel

class GetPokemonByName(
    private val pokemonApiRepository: PokemonApiRepository
) {
    suspend operator fun invoke(name: String): PokemonDataModel{
        return pokemonApiRepository.getPokemonByName(name).mapPokemonEntity()
    }
}