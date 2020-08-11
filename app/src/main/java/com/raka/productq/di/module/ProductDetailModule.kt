package com.raka.productq.di.module

import androidx.lifecycle.ViewModel
import com.raka.productq.data.repository.ProductDetailRepositoryImpl
import com.raka.productq.di.ViewModelKey
import com.raka.productq.domain.productdetail.ProductDetailRepository
import com.raka.productq.domain.productdetail.ProductDetailUsecase
import com.raka.productq.domain.productdetail.ProductDetailUsecaseImpl
import com.raka.productq.presentation.ui.productdetail.ProductDetailViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductDetailModule {
    @Binds
    @ActivityScope
    abstract fun bindsProductDetailRepository(repository:ProductDetailRepositoryImpl):ProductDetailRepository

    @Binds
    @ActivityScope
    abstract fun bindsProductDetailUsecase(usecase: ProductDetailUsecaseImpl):ProductDetailUsecase

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    abstract fun bindProductDetailViewModel(viewModel: ProductDetailViewModel):ViewModel
}