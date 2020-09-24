package com.raka.productq.dihilt

import com.raka.productq.data.repository.ProductListRepositoryImpl
import com.raka.productq.domain.productlist.ProductListRepository
import com.raka.productq.domain.productlist.ProductListUsecase
import com.raka.productq.domain.productlist.ProductListUsecaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ProductListModule {
    @Binds
    abstract fun bindProductListUsecase(usecase: ProductListUsecaseImpl): ProductListUsecase

    @Binds
    abstract fun bindProductListRepository(repository: ProductListRepositoryImpl): ProductListRepository
}