package com.example.vktechnotest.domain.repository

import androidx.paging.PagingData
import com.example.vktechnotest.data.dto.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(): Flow<PagingData<Product>>

}