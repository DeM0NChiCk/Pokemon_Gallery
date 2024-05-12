package com.example.pg.domain.usecase

import com.example.pg.domain.entity.mapPokemonListEntity
import com.example.pg.domain.repository.PokemonApiRepository
import com.example.pg.ui.model.PokemonListDataModel

class GetPokemonListUseCase(
    private val pokemonApiRepository: PokemonApiRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int): PokemonListDataModel {
        return pokemonApiRepository.getPokemonList(offset, limit).mapPokemonListEntity()
    }
}