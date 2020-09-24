package com.raka.productq.domain.productlist

import com.raka.productq.data.model.ProductListCompact
import com.raka.productq.presentation.ui.productlist.ProductListMapper
import javax.inject.Inject


class ProductListUsecaseImpl @Inject constructor(
    private val repository: ProductListRepository,
    private val mapper: ProductListMapper
) : ProductListUsecase {
    override suspend fun fetchProductListData(): List<ProductListCompact>? =
        repository.getProductListFromDb()
            ?.map { data -> mapper.convertProductListLocalToCompact(data)!! }
}