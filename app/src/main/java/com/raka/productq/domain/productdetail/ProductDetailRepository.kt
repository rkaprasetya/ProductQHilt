package com.raka.productq.domain.productdetail

import com.raka.productq.data.model.ProductLocal

interface ProductDetailRepository {
    suspend fun getDetailFromDb(id:Int): ProductLocal?
}