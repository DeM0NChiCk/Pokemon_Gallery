package com.example.pg.data.api.mappers

import com.example.pg.data.api.model.response.OtherResponse
import com.example.pg.data.api.model.response.PokemonListResponse
import com.example.pg.data.api.model.response.PokemonResponse
import com.example.pg.data.api.model.response.PokemonSprite
import com.example.pg.data.api.model.response.ResultResponse
import com.example.pg.data.api.model.response.ShowdownResponse
import com.example.pg.domain.entity.OtherEntity
import com.example.pg.domain.entity.PokemonAbilityEntity
import com.example.pg.domain.entity.PokemonEntity
import com.example.pg.domain.entity.PokemonListEntity
import com.example.pg.domain.entity.PokemonSpriteEntity
import com.example.pg.domain.entity.PokemonStatsEntity
import com.example.pg.domain.entity.PokemonTypeEntity
import com.example.pg.domain.entity.ResultEntity
import com.example.pg.domain.entity.ShowdownEntity

class PokemonApiResponseMappers {

    fun mapPokemonListResponse(item: PokemonListResponse): PokemonListEntity {
        return with(item) {
            PokemonListEntity(
                count = count ?: 0,
                next = next ?: "",
                previous = previous ?: "",
                results = results.map { results ->
                    ResultEntity(
                        name = results.name ?: "",
                        url = results.url ?: ""
                    )
                }
            )
        }
    }

    fun mapPokemonResponse(item: PokemonResponse): PokemonEntity {
        return with(item) {
            PokemonEntity(
                name = name ?: "",
                weight = weight ?: 0,
                height = height ?: 0,
                baseExperience = baseExperience ?: 0,
                abilities = abilities.map { abilities ->
                    PokemonAbilityEntity(
                        ability = mapResultResponse(abilities.ability),
                        isHidden = abilities.isHidden ?: false,
                        slot = abilities.slot ?: 0
                    )
                },
                stats = stats.map { stats ->
                    PokemonStatsEntity(
                        baseStat = stats.baseStat ?: 0,
                        effort = stats.effort ?: 0,
                        stat = mapResultResponse(stats.stat),
                    )
                },
                sprites = mapPokemonSpriteEntity(sprites),
                types = types.map { types ->
                    PokemonTypeEntity(
                        slot = types.slot ?: 0,
                        type = mapResultResponse(types.type)
                    )
                }
            )
        }
    }

    private fun mapResultResponse(item: ResultResponse): ResultEntity {
        return with(item) {
            ResultEntity(
                name = name ?: "",
                url = url ?: ""
            )
        }
    }

    private fun mapPokemonSpriteEntity(item: PokemonSprite): PokemonSpriteEntity {
        return with(item) {
            PokemonSpriteEntity(
                backDefault = backDefault ?: "",
                backFemale = backFemale ?: "",
                backShiny = backShiny ?: "",
                backShinyFemale = backShinyFemale ?: "",
                frontDefault = frontDefault ?: "",
                frontFemale = frontFemale ?: "",
                frontShiny = frontShiny ?: "",
                frontShinyFemale = frontShinyFemale ?: "",
                other = mapOtherResponse(other)
            )
        }
    }

    private fun mapOtherResponse(item: OtherResponse): OtherEntity {
        return with(item) {
            OtherEntity(
                showdown = mapShowdownResponse(showdown)
            )
        }
    }

    private fun mapShowdownResponse(item: ShowdownResponse): ShowdownEntity {
        return with(item) {
            ShowdownEntity(
                backDefault = backDefault ?: "",
                backFemale = backFemale ?: "",
                backShiny = backShiny ?: "",
                backShinyFemale = backShinyFemale ?: "",
                frontDefault = frontDefault ?: "",
                frontFemale = frontFemale ?: "",
                frontShiny = frontShiny ?: "",
                frontShinyFemale = frontShinyFemale ?: "",
            )
        }
    }
}