package com.raka.productq.presentation.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.raka.productq.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_splash.*

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private val viewModel: SplashViewModel by viewModels()

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
            if (it) {
                openProductList()
            }
        })
        viewModel.isError.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { isError ->
                if (isError) {
                    Snackbar.make(
                        main_layout,
                        getString(R.string.server_error),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun openProductList() {
        val action = SplashFragmentDirections.actionSplashFragmentToProductListFragment()
        findNavController().navigate(action)
    }
}