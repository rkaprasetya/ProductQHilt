package com.raka.productq.domain.productlist

import com.raka.productq.data.model.ProductLocal

interface ProductListRepository {
    suspend fun getProductListFromDb(): List<ProductLocal>?
}