package com.raka.productq.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productlist")
data class ProductLocal(
    @ColumnInfo(name = "productId")
    @PrimaryKey(autoGenerate = false)
    val productId: Int? = null,
    @ColumnInfo(name = "price")
    val price: Int? = null,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "stock")
    val stock: Int? = null,
    @ColumnInfo(name = "productName")
    val productName: String? = null,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String? = null,
    @ColumnInfo(name = "large")
    val large: String? = null,
    @ColumnInfo(name = "banner")
    val banner:String? = null)
