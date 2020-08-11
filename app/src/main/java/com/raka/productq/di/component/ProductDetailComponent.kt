package com.raka.productq.di.component

import com.raka.productq.di.module.ActivityScope
import com.raka.productq.di.module.ProductDetailModule
import com.raka.productq.presentation.ui.productdetail.ProductDetailFragment
import dagger.Component

@Component(dependencies = [AppComponent::class],modules = [ProductDetailModule::class])
@ActivityScope
interface ProductDetailComponent {
    fun inject(fragment:ProductDetailFragment)
}