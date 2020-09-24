package com.raka.productq.presentation.ui.splash

import com.raka.productq.data.model.ProductLocal
import com.raka.productq.data.model.ProductsItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashMapper @Inject constructor() {
    fun convertProductListRemoteToLocal(
        dataRemote: List<ProductsItem?>?,
        banner: String
    ): MutableList<ProductLocal> {
        val listLocal: MutableList<ProductLocal> = mutableListOf()
        dataRemote!!.forEach { item ->
            listLocal.add(
                ProductLocal(
                    item!!.productId,
                    item.price, item.description,
                    item.stock, item.productName, item.images!!.thumbnail,
                    item.images.large, banner
                )
            )
        }
        return listLocal
    }
}