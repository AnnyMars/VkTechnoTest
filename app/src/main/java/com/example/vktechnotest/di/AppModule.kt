package com.example.vktechnotest.di

import com.example.vktechnotest.Utils.BASE_URL
import com.example.vktechnotest.data.remote.ProductApi
import com.example.vktechnotest.data.repository.ProductRepositoryImpl
import com.example.vktechnotest.domain.repository.ProductRepository
import com.example.vktechnotest.domain.usecases.GetProducts
import com.example.vktechnotest.domain.usecases.ProductUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideApiInstance(okHttpClient: OkHttpClient): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        productApi: ProductApi
    ): ProductRepository{
        return ProductRepositoryImpl(productApi = productApi)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        productRepository: ProductRepository
    ): ProductUseCases{
        return ProductUseCases(
            getProducts = GetProducts(productRepository)
        )
    }

}