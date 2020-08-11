package com.raka.productq.presentation.ui.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raka.productq.domain.splash.SplashUsecaseImpl
import com.raka.productq.utils.Util
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val splashUseCase: SplashUsecaseImpl):ViewModel() {
    private val compositeDisposable =CompositeDisposable()
    private var _finishFetching = MutableLiveData(false)
    val finishFetching : LiveData<Boolean>
    get() = _finishFetching
    fun loadProductList(){
        viewModelScope.launch {
            val isInternetAvailable = withContext(Dispatchers.Default){
                Util.isInternetAvailable()
            }
            if (isInternetAvailable){
                loadProductListRemote()
            }else{
                _finishFetching.value = true
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun loadProductListRemote() {
        val disposable = splashUseCase.fetchProductListFromServer()
            .subscribe({
                _finishFetching.value = true
            },{
                Log.e("SplashViewModel","Error message ${it.message}")
                _finishFetching.value = true
            })
        compositeDisposable.add(disposable)
    }
}