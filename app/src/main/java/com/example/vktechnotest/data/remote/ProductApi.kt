package com.example.vktechnotest.data.remote

import com.example.vktechnotest.data.dto.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): ProductResponse

    @GET("/products/category/{category}")
    suspend fun getCategory(@Path("category") category: String): ProductResponse

}