package com.raka.productq

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

/**
 * Dagger 2 ViewModelFactory tutorial:
https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c
 * Moshi tutorial
 * https://proandroiddev.com/getting-started-using-moshi-for-json-parsing-with-kotlin-5a460bf3935a
 * https://blog.mindorks.com/moshi-json-library-for-android
 */
@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()
}