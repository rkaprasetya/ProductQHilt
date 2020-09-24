package com.raka.productq.presentation.ui.productdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raka.productq.data.model.ProductDetailCompact
import com.raka.productq.domain.productdetail.ProductDetailUsecaseImpl
import kotlinx.coroutines.launch

class ProductDetailViewModel @ViewModelInject constructor(private val usecase: ProductDetailUsecaseImpl) :
    ViewModel() {
    private var _productDetail: MutableLiveData<ProductDetailCompact> = MutableLiveData()
    val productDetail: LiveData<ProductDetailCompact>
        get() = _productDetail

    fun fetchProductDetail(id: Int) {
        viewModelScope.launch {
            _productDetail.value = usecase.getProductDetail(id)
        }
    }
}