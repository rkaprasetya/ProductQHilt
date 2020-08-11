package com.raka.productq.presentation.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.raka.productq.QApp
import com.raka.productq.R
import com.raka.productq.di.component.DaggerSplashComponent
import com.raka.productq.utils.ViewModelFactory
import com.raka.productq.utils.ViewModelsFactoryDi
import javax.inject.Inject

class SplashFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelsFactoryDi
    private lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashComponent.builder()
            .appComponent((requireActivity().application as QApp).component)
            .build()
            .inject(this)
        viewModel = ViewModelProvider(this,viewModelFactory).get(SplashViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.loadProductList()
    }
    private fun setupObserver() {
        viewModel.finishFetching.observe(viewLifecycleOwner, Observer {
            if (it){
                openProductList()
            }
        })
    }
    private fun openProductList() {
        val action = SplashFragmentDirections.actionSplashFragmentToProductListFragment()
        findNavController().navigate(action)
    }
}