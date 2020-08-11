package com.raka.productq.domain.productdetail

import com.raka.productq.data.model.ProductDetailCompact

interface ProductDetailUsecase {
    suspend fun getProductDetail(id:Int): ProductDetailCompact
}