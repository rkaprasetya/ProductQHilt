package com.raka.productq.presentation.ui.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raka.productq.data.model.ProductListCompact
import com.raka.productq.domain.productlist.ProductListUsecaseImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(private val usecase: ProductListUsecaseImpl):ViewModel() {
    private var _productList:MutableLiveData<List<ProductListCompact>> = MutableLiveData()
    val productList:LiveData<List<ProductListCompact>>
    get() = _productList
    fun getProductListData(){
        viewModelScope.launch {
            _productList.value = usecase.fetchProductListData()
        }
    }
}