package com.raka.productq.presentation.ui.productlist

import com.raka.productq.data.model.ProductListCompact
import com.raka.productq.data.model.ProductLocal
import javax.inject.Inject

class ProductListMapper @Inject constructor() {
    fun convertProductListLocalToCompact(dataLocal: ProductLocal): ProductListCompact? {
        return ProductListCompact(
            dataLocal.productId,
            dataLocal.thumbnail,
            dataLocal.productName,
            dataLocal.price,
            dataLocal.stock,
            dataLocal.banner
        )
    }
}