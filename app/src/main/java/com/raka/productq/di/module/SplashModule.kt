package com.raka.productq.di.module

import androidx.lifecycle.ViewModel
import com.raka.productq.data.repository.SplashRepositoryImpl
import com.raka.productq.di.ViewModelKey
import com.raka.productq.domain.splash.SplashRepository
import com.raka.productq.domain.splash.SplashUsecase
import com.raka.productq.domain.splash.SplashUsecaseImpl
import com.raka.productq.presentation.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {
    @Binds
    @ActivityScope
    abstract fun bindRepoListUsecase(usecase:SplashUsecaseImpl):SplashUsecase

    @Binds
    @ActivityScope
    abstract fun bindSplashRepository(repositoryImpl: SplashRepositoryImpl):SplashRepository

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewMdoel(viewModel: SplashViewModel):ViewModel
}