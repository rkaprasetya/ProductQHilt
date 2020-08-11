package com.raka.productq.data.api

import com.raka.productq.data.model.ProductListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("b/5ee794370e966a7aa369eafd")
    fun getProductList():Single<ProductListResponse>
}