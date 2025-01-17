package com.example.vktechnotest.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("limit")
    val limit: Int,
    @SerialName("products")
    val products: List<Product>,
    @SerialName("skip")
    val skip: Int,
    @SerialName("total")
    val total: Int
)