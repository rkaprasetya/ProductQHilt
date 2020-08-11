package com.raka.productq.domain.productlist

import com.raka.productq.data.model.ProductListCompact

interface ProductListUsecase {
    suspend fun fetchProductListData():List<ProductListCompact>?
}