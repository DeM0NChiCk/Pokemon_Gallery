package com.example.pg.domain.entity

import com.example.pg.ui.model.ResultDataModel

data class ResultEntity (
    val name: String,
    val url: String,
)

fun ResultEntity.mapResultEntity(): ResultDataModel{
    return ResultDataModel(
        name = name,
        url = url,
    )
}