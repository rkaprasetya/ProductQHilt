package com.raka.productq.presentation.ui.splash

import android.util.Log
import com.raka.productq.data.model.ProductLocal
import com.raka.productq.data.model.ProductsItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

class SplashMapper @Inject constructor() {
    fun convertProductListRemoteToLocal(dataRemote:List<ProductsItem?>?, banner: String):MutableList<ProductLocal>{
        val moshi : Moshi = Moshi.Builder().build()
        val adapter:JsonAdapter<ProductsItem> = moshi.adapter(ProductsItem::class.java)
        val listLocal : MutableList<ProductLocal> = mutableListOf()
        dataRemote!!.forEach { item ->
            Log.e("adapter", adapter.toJson(item))
            listLocal.add(
                ProductLocal(item!!.productId,
            item.price,item.description,
            item.stock,item.productName,item.images!!.thumbnail,
            item.images.large,banner)
            )
        }
        return listLocal
    }
}