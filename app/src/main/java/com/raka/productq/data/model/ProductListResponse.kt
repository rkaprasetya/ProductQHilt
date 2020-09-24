package com.raka.productq.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductListResponse(
    @Json(name = "data")
    val data: Data? = null,
    @Json(name = "message")
    val message: String? = null,
    @Json(name = "status")
    val status: String? = null
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "banner")
    val banner: String? = null,
    @Json(name = "products")
    val products: List<ProductsItem?>? = null
)

@JsonClass(generateAdapter = true)
data class ProductsItem(
    @Json(name = "images")
    val images: Images? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "product_id")
    val productId: Int? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "stock")
    val stock: Int? = null,
    @Json(name = "product_name")
    val productName: String? = null
)

@JsonClass(generateAdapter = true)
data class Images(
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
    @Json(name = "large")
    val large: String? = null
)

