package com.raka.productq.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raka.productq.data.api.ApiClient
import com.raka.productq.data.api.ApiService
import com.raka.productq.data.database.AppDatabase
import com.raka.productq.data.database.ParametersDao
import com.raka.productq.data.repository.ProductDetailRepositoryImpl
import com.raka.productq.data.repository.ProductListRepositoryImpl
import com.raka.productq.data.repository.SplashRepositoryImpl
import com.raka.productq.domain.productdetail.ProductDetailUsecaseImpl
import com.raka.productq.domain.productlist.ProductListUsecaseImpl
import com.raka.productq.domain.splash.SplashUsecaseImpl
import com.raka.productq.presentation.ui.productdetail.ProductDetailMapper
import com.raka.productq.presentation.ui.productdetail.ProductDetailViewModel
import com.raka.productq.presentation.ui.productlist.ProductListMapper
import com.raka.productq.presentation.ui.productlist.ProductListViewModel
import com.raka.productq.presentation.ui.splash.SplashMapper
import com.raka.productq.presentation.ui.splash.SplashViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            val apiService:ApiService = ApiClient().apiService
            val dao :ParametersDao = AppDatabase.getInstance(context).parametersDao()
            val repository = SplashRepositoryImpl(apiService,dao)
            val splashUseCase = SplashUsecaseImpl(
                repository,
                SplashMapper()
            )
            return SplashViewModel(splashUseCase) as T
        }else if(modelClass.isAssignableFrom(ProductListViewModel::class.java)){
            val dao :ParametersDao = AppDatabase.getInstance(context).parametersDao()
            val repository = ProductListRepositoryImpl(dao)
            val usecase =
                ProductListUsecaseImpl(
                    repository,
                    ProductListMapper()
                )
            return ProductListViewModel(usecase) as T
        }else if ((modelClass.isAssignableFrom(ProductDetailViewModel::class.java))){
            val dao :ParametersDao = AppDatabase.getInstance(context).parametersDao()
            val repository = ProductDetailRepositoryImpl(dao)
            val usecase =
                ProductDetailUsecaseImpl(
                    repository,
                    ProductDetailMapper()
                )
            return ProductDetailViewModel(usecase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}