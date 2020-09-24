package com.raka.productq.domain.splash

import com.raka.productq.data.repository.SplashRepositoryImpl
import com.raka.productq.presentation.ui.splash.SplashMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashUsecaseImpl @Inject constructor(
    private val repository: SplashRepositoryImpl,
    private val mapper: SplashMapper
) : SplashUsecase {
    override fun fetchProductListFromServer() = repository.getProductListRemote()
        .map {
            mapper.convertProductListRemoteToLocal(it.data?.products, it.data?.banner!!)
        }
        .flatMap { repository.insertProductListToDb(it) }
}