package com.raka.productq.data.database

import androidx.room.*
import com.raka.productq.data.model.ProductLocal
import io.reactivex.Single

@Dao
interface ParametersDao {
    @Transaction
    fun insertProductListAll(data:List<ProductLocal>){
        deleteProductlist()
        insertProductList(data)
    }
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertProductList(data:List<ProductLocal>)
    @Query("DELETE FROM productlist")
    fun deleteProductlist()
    @Query("SELECT * from productlist")
    suspend fun getProductList(): List<ProductLocal>?
    @Query("SELECT * from productlist WHERE productId=:id")
    suspend fun getProductDetail(id:Int): ProductLocal?
    @Query("SELECT * from productlist")
    fun getProductListRx(): Single<List<ProductLocal>>
}