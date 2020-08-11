package com.raka.productq.data.repository

import com.raka.productq.data.api.ApiService
import com.raka.productq.data.database.ParametersDao
import com.raka.productq.data.model.ProductLocal
import com.raka.productq.domain.splash.SplashRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(private val apiService: ApiService, private val dao: ParametersDao):
    SplashRepository {
    override fun getProductListRemote() = apiService.getProductList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
    override fun insertProductListToDb(list: List<ProductLocal>):Single<Unit> {
        return Single.fromCallable{dao.insertProductListAll(list)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}