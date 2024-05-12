package com.example.pg.domain.entity

import com.example.pg.ui.model.OtherDataModel

data class OtherEntity (
    val showdown: ShowdownEntity
)

fun OtherEntity.mapOtherEntity(): OtherDataModel {
    return OtherDataModel(
        showdown = showdown.mapShowdownEntity()
    )
}