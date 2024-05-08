package com.example.vktechnotest.domain.usecases

import androidx.paging.PagingData
import com.example.vktechnotest.data.dto.Product
import com.example.vktechnotest.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProducts(
    private val productRepository: ProductRepository
) {
    operator fun invoke(): Flow<PagingData<Product>> {
        return productRepository.getProducts()
    }
}