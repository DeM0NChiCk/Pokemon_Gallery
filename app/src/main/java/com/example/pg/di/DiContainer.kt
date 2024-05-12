package com.example.pg.di

import com.example.pg.data.api.mappers.PokemonApiResponseMappers
import com.example.pg.data.api.repository.PokemonApiRepositoryImpl
import com.example.pg.data.api.service.PokemonService
import com.example.pg.domain.repository.PokemonApiRepository
import com.example.pg.domain.usecase.GetPokemonByName
import com.example.pg.domain.usecase.GetPokemonListUseCase
import com.example.pg.ui.screen.mvi.info.InfoActor
import com.example.pg.ui.screen.mvi.info.InfoReducer
import com.example.pg.ui.screen.mvi.info.InfoStoreFactory
import com.example.pg.ui.screen.mvi.list.ListActor
import com.example.pg.ui.screen.mvi.list.ListReducer
import com.example.pg.ui.screen.mvi.list.ListStoreFactory

object DiContainer {

    private val getPokemonUseCase by lazyNone {
        GetPokemonListUseCase(repositoryApiPokemon)
    }

    private val getPokemonByName by lazyNone {
        GetPokemonByName(repositoryApiPokemon)
    }

    private val pokemonApiResponseMapper = PokemonApiResponseMappers()

    private val pokemonApi = PokemonService.getInstance()

    private val repositoryApiPokemon: PokemonApiRepository by lazyNone {
        PokemonApiRepositoryImpl(
            remoteSource = pokemonApi,
            pokemonApiResponseMappers = pokemonApiResponseMapper
        )
    }

    val listStoreFactory by lazyNone {
        ListStoreFactory(listReducer, listActor)
    }

    private val listReducer by lazyNone {
        ListReducer()
    }

    private val listActor by lazyNone {
        ListActor(getPokemonUseCase)
    }

    val infoStoreFactory by lazyNone {
        InfoStoreFactory(infoReducer, infoActor)
    }

    private val infoReducer by lazyNone {
        InfoReducer()
    }

    private val infoActor by lazyNone {
        InfoActor(getPokemonByName)
    }


}

private fun <T> lazyNone(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)