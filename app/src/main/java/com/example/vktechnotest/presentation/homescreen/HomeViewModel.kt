package com.example.vktechnotest.presentation.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.vktechnotest.domain.usecases.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    productUseCase: ProductUseCases
): ViewModel() {

    val products = productUseCase.getProducts().cachedIn(viewModelScope)
}