package com.raka.productq.presentation.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.api.load
import com.google.android.material.appbar.AppBarLayout
import com.raka.productq.R
import com.raka.productq.data.model.ProductDetailCompact
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_product_detail.*
import kotlinx.android.synthetic.main.fragment_product_detail.view.*

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private val viewModel: ProductDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_product_detail, container, false)
        val isTablet = context!!.resources.getBoolean(R.bool.isTablet)
        if (!isTablet) {
            mView.appbar_product_detail.setOnClickListener {
                findNavController().popBackStack()
            }
            val appBar: AppBarLayout = mView.findViewById(R.id.appbar_product_detail)
            appBar.visibility = View.VISIBLE
        }
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        val id = ProductDetailFragmentArgs.fromBundle(arguments!!).id
        viewModel.fetchProductDetail(id)
    }

    private fun setupObserver() {
        viewModel.productDetail.observe(viewLifecycleOwner, Observer {
            setData(it)
        })
    }

    private fun setData(productDetailCompact: ProductDetailCompact) {
        iv_detail.load(productDetailCompact.large) {
            placeholder(R.drawable.ic_baseline_emoji_emotions_24)
            error(R.drawable.ic_baseline_error_24)
        }
        iv_detail.visibility = View.VISIBLE
        ll_detail.visibility = View.VISIBLE
        tv_detail_appbar.text = productDetailCompact.productName
        tv_detail_desc.text = productDetailCompact.description
        tv_detail_price.text =
            getString(R.string.detail_price, productDetailCompact.price.toString())
        tv_detail_title.text = productDetailCompact.productName
    }
}