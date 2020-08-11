package com.raka.productq.domain.splash

import com.raka.productq.data.model.ProductListResponse
import com.raka.productq.data.model.ProductLocal
import io.reactivex.Single

interface SplashRepository {
    fun getProductListRemote(): Single<ProductListResponse>
    fun insertProductListToDb(list: List<ProductLocal>):Single<Unit>
}