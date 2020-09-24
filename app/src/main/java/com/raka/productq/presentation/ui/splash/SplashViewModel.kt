package com.raka.productq.presentation.ui.splash

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raka.productq.domain.splash.SplashUsecaseImpl
import com.raka.productq.utils.Event
import com.raka.productq.utils.Util
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel @ViewModelInject constructor(private val splashUseCase: SplashUsecaseImpl) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private var _finishFetching: MutableLiveData<Boolean> = MutableLiveData(false)
    val finishFetching: LiveData<Boolean>
        get() = _finishFetching
    private var _isError = MutableLiveData<Event<Boolean>>()
    val isError: LiveData<Event<Boolean>>
        get() = _isError

    fun loadProductList() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                Util.isInternetAvailable()
            }.takeIf { it }?.let {
                loadProductListRemote()
            } ?: setFinishFetchingData()
        }
    }

    private fun setFinishFetchingData() {
        _finishFetching.value = true

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun loadProductListRemote() {
        val disposable = splashUseCase.fetchProductListFromServer()
            .doFinally { setFinishFetchingData() }
            .subscribe({
            }, {
                _isError.value = Event(true)
                Log.e("Error", "Error ${it.message}")
            })
        compositeDisposable.add(disposable)
    }
}