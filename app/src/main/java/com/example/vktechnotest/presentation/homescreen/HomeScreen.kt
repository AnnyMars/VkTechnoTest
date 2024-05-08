package com.example.vktechnotest.presentation.homescreen

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.example.vktechnotest.data.dto.Product
import com.example.vktechnotest.presentation.common.ProductList

@Composable
fun HomeScreen(
    products: LazyPagingItems<Product>
){
    ProductList(products = products)
}