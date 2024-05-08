package com.example.vktechnotest.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.vktechnotest.data.dto.Product

class ProductPagingSource(
    private val productApi: ProductApi
): PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = productApi.getProducts(
                skip = nextPageNumber,
                limit = params.loadSize
            )

            LoadResult.Page(
                data = response.products,
                prevKey = null, // Only paging forward.
                nextKey = if (response.products.isEmpty()) null else nextPageNumber + params.loadSize
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition
    }
}