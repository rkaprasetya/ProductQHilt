package com.raka.productq.domain.productdetail

import com.raka.productq.data.model.ProductDetailCompact
import com.raka.productq.presentation.ui.productdetail.ProductDetailMapper
import javax.inject.Inject


class ProductDetailUsecaseImpl @Inject constructor(
    private val repository: ProductDetailRepository,
    private val mapper: ProductDetailMapper
) : ProductDetailUsecase {
    override suspend fun getProductDetail(id: Int): ProductDetailCompact =
        repository.getDetailFromDb(id).let { mapper.convertProductDetailLocalToCompact(it!!) }
}