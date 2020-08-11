package com.raka.productq.di.component

import com.raka.productq.data.api.ApiService
import com.raka.productq.data.database.ParametersDao
import com.raka.productq.di.module.AppModule
import com.raka.productq.di.module.DatabaseModule
import com.raka.productq.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class,NetworkModule::class,AppModule::class])
@Singleton
interface AppComponent {
    fun provideParametersDao():ParametersDao
    fun provideRetrofit():ApiService
}