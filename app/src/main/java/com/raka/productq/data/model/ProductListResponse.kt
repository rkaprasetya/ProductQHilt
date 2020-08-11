package com.raka.productq.data.model

import com.google.gson.annotations.SerializedName

data class ProductListResponse(
	@field:SerializedName("data")
	val data: Data? = null,
	@field:SerializedName("message")
	val message: String? = null,
	@field:SerializedName("status")
	val status: String? = null
)
data class Data(
	@field:SerializedName("banner")
	val banner: String? = null,
	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null
)
data class ProductsItem(
	@field:SerializedName("images")
	val images: Images? = null,
	@field:SerializedName("price")
	val price: Int? = null,
	@field:SerializedName("product_id")
	val productId: Int? = null,
	@field:SerializedName("description")
	val description: String? = null,
	@field:SerializedName("stock")
	val stock: Int? = null,
	@field:SerializedName("product_name")
	val productName: String? = null
)
data class Images(
	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,
	@field:SerializedName("large")
	val large: String? = null
)

