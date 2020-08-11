package com.raka.productq.di.module

import androidx.lifecycle.ViewModel
import com.raka.productq.data.repository.ProductListRepositoryImpl
import com.raka.productq.di.ViewModelKey
import com.raka.productq.domain.productlist.ProductListRepository
import com.raka.productq.domain.productlist.ProductListUsecase
import com.raka.productq.domain.productlist.ProductListUsecaseImpl
import com.raka.productq.presentation.ui.productlist.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductListModule {
    @Binds
    @ActivityScope
    abstract fun bindProductListUsecase(usecase: ProductListUsecaseImpl):ProductListUsecase

    @Binds
    @ActivityScope
    abstract fun bindProductListRepository(repository: ProductListRepositoryImpl):ProductListRepository

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun bindProductListViewModel(viewModel: ProductListViewModel):ViewModel
}