package com.example.vktechnotest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.vktechnotest.data.dto.Product
import com.example.vktechnotest.data.remote.ProductApi
import com.example.vktechnotest.data.remote.ProductPagingSource
import com.example.vktechnotest.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val productApi: ProductApi
) : ProductRepository {
    override fun getProducts(): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { ProductPagingSource(productApi) }
        ).flow
    }
}