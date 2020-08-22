package com.raka.productq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController

/**
 * Dagger 2 ViewModelFactory tutorial:
https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c
 * Moshi tutorial
 * https://proandroiddev.com/getting-started-using-moshi-for-json-parsing-with-kotlin-5a460bf3935a
 * https://blog.mindorks.com/moshi-json-library-for-android
 */
class ProductListActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        navController = Navigation.findNavController(this,R.id.main_nav_fragment)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()
}