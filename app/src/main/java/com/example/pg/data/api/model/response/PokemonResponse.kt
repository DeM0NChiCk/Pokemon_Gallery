package com.example.pg.data.api.model.response

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count")
    val count: Int ?= 0,
    @SerializedName("next")
    val next: String ?= "",
    @SerializedName("previous")
    val previous: String ?= "",
    @SerializedName("results")
    val results: List<ResultResponse>
)

data class ResultResponse(
    @SerializedName("name")
    val name: String ?= "",
    @SerializedName("url")
    val url: String ?= "",
)

data class PokemonResponse(
    @SerializedName("name")
    val name: String ?= "",
    @SerializedName("weight")
    val weight: Int? = 0,
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("base_experience")
    val baseExperience: Int? = 0,
    @SerializedName("abilities")
    val abilities: List<PokemonAbility>,
    @SerializedName("stats")
    val stats: List<PokemonStats>,
    @SerializedName("sprites")
    val sprites: PokemonSprite,
    @SerializedName("types")
    val types: List<PokemonType>,
)

data class PokemonStats(
    @SerializedName("base_stat")
    val baseStat: Int ?= 0,
    @SerializedName("effort")
    val effort: Int ?= 0,
    @SerializedName("stat")
    val stat: ResultResponse
)

data class PokemonAbility(
    @SerializedName("ability")
    val ability: ResultResponse,
    @SerializedName("is_hidden")
    val isHidden: Boolean ?= false,
    @SerializedName("slot")
    val slot: Int?= 0
)

data class PokemonSprite(
    @SerializedName("back_default")
    val backDefault: String ?= "",
    @SerializedName("back_female")
    val backFemale: String ?= "",
    @SerializedName("back_shiny")
    val backShiny: String ?= "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String ?= "",
    @SerializedName("front_default")
    val frontDefault: String ?= "",
    @SerializedName("front_female")
    val frontFemale: String ?= "",
    @SerializedName("front_shiny")
    val frontShiny: String ?= "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String ?= "",
    @SerializedName("other")
    val other: OtherResponse,
)

data class OtherResponse(
    @SerializedName("showdown")
    val showdown: ShowdownResponse
)

data class ShowdownResponse(
    @SerializedName("back_default")
    val backDefault: String ?= "",
    @SerializedName("back_female")
    val backFemale: String ?= "",
    @SerializedName("back_shiny")
    val backShiny: String ?= "",
    @SerializedName("back_shiny_female")
    val backShinyFemale: String ?= "",
    @SerializedName("front_default")
    val frontDefault: String ?= "",
    @SerializedName("front_female")
    val frontFemale: String ?= "",
    @SerializedName("front_shiny")
    val frontShiny: String ?= "",
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String ?= "",
)

data class PokemonType(
    @SerializedName("slot")
    val slot: Int ?= 0,
    @SerializedName("type")
    val type: ResultResponse
)

