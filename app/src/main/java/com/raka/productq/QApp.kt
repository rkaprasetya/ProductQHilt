package com.raka.productq

import android.app.Application
import com.raka.productq.di.component.AppComponent
import com.raka.productq.di.component.DaggerAppComponent
import com.raka.productq.di.module.AppModule

class QApp:Application(){
    lateinit var component: AppComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}