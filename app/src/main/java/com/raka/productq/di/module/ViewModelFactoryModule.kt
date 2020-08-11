package com.raka.productq.di.module

import androidx.lifecycle.ViewModelProvider
import com.raka.productq.utils.ViewModelFactory
import com.raka.productq.utils.ViewModelsFactoryDi
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelsFactoryDi):ViewModelProvider.Factory
}