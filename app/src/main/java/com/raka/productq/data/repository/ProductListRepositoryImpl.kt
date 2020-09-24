package com.raka.productq.data.repository

import com.raka.productq.data.database.ParametersDao
import com.raka.productq.domain.productlist.ProductListRepository
import javax.inject.Inject


class ProductListRepositoryImpl @Inject constructor(private val dao:ParametersDao):
    ProductListRepository {
    override suspend fun getProductListFromDb() = dao.getProductList()
}