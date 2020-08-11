package com.raka.productq.domain.splash

import io.reactivex.Single

interface SplashUsecase {
        fun fetchProductListFromServer(): Single<Unit>
}