package com.raka.productq.data.repository

import com.raka.productq.data.database.ParametersDao
import com.raka.productq.data.model.ProductLocal
import com.raka.productq.domain.productdetail.ProductDetailRepository
import javax.inject.Inject


class ProductDetailRepositoryImpl @Inject constructor(private val dao: ParametersDao):
    ProductDetailRepository {
    override suspend fun getDetailFromDb(id:Int): ProductLocal? = dao.getProductDetail(id)
}