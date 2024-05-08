package com.example.vktechnotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.vktechnotest.presentation.homescreen.HomeScreen
import com.example.vktechnotest.presentation.homescreen.HomeViewModel
import com.example.vktechnotest.ui.theme.VkTechnoTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<HomeViewModel>()
            VkTechnoTestTheme {
                HomeScreen(products = viewModel.products.collectAsLazyPagingItems())
            }
        }
    }
}
