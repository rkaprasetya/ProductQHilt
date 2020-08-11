package com.raka.productq.di.component

import com.raka.productq.di.module.ActivityScope
import com.raka.productq.di.module.ProductListModule
import com.raka.productq.presentation.ui.productlist.ProductListFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [ProductListModule::class])
@ActivityScope
interface ProductListComponent {
    fun inject(fragment: ProductListFragment)
}