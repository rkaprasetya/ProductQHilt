package com.raka.productq.presentation.ui.productdetail

import com.raka.productq.data.model.ProductDetailCompact
import com.raka.productq.data.model.ProductLocal
import javax.inject.Inject

class ProductDetailMapper @Inject constructor() {
    fun convertProductDetailLocalToCompact(dataLocal: ProductLocal): ProductDetailCompact {
        return ProductDetailCompact(
            dataLocal.productName,
            dataLocal.price,
            dataLocal.description,
            dataLocal.large
        )
    }
}