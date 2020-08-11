package com.raka.productq.di.component

import com.raka.productq.di.module.ActivityScope
import com.raka.productq.di.module.SplashModule
import com.raka.productq.presentation.ui.splash.SplashFragment
import dagger.Component

@Component(dependencies = [AppComponent::class],modules = [SplashModule::class])
@ActivityScope
interface SplashComponent {
    fun inject(splashFragment: SplashFragment)
}