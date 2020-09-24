package com.raka.productq.dihilt

import com.raka.productq.data.repository.ProductDetailRepositoryImpl
import com.raka.productq.domain.productdetail.ProductDetailRepository
import com.raka.productq.domain.productdetail.ProductDetailUsecase
import com.raka.productq.domain.productdetail.ProductDetailUsecaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class ProductDetailModule {
    @Binds
    abstract fun bindsProductDetailRepository(repository: ProductDetailRepositoryImpl): ProductDetailRepository

    @Binds
    abstract fun bindsProductDetailUsecase(usecase: ProductDetailUsecaseImpl): ProductDetailUsecase
}