package com.raka.productq.presentation.ui.productdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.raka.productq.QApp
import com.raka.productq.R
import com.raka.productq.data.model.ProductDetailCompact
import com.raka.productq.di.component.DaggerProductDetailComponent
import com.raka.productq.utils.ViewModelFactory
import com.raka.productq.utils.ViewModelsFactoryDi
import kotlinx.android.synthetic.main.fragment_product_detail.*
import kotlinx.android.synthetic.main.fragment_product_detail.view.*
import javax.inject.Inject

class ProductDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelsFactoryDi
    private lateinit var viewModel: ProductDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerProductDetailComponent.builder()
            .appComponent((requireActivity().application as QApp).component)
            .build()
            .inject(this)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ProductDetailViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_product_detail, container, false)
        val isTablet = context!!.resources.getBoolean(R.bool.isTablet)
        if(!isTablet){
            mView.appbar_product_detail.setOnClickListener {
                findNavController().popBackStack()
            }
            val appBar : AppBarLayout = mView.findViewById(R.id.appbar_product_detail)
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
        Glide.with(this).load(productDetailCompact.large).into(iv_detail)
        iv_detail.visibility = View.VISIBLE
        ll_detail.visibility = View.VISIBLE
        tv_detail_appbar.text = productDetailCompact.productName
        tv_detail_desc.text = productDetailCompact.description
        tv_detail_price.text = getString(R.string.detail_price,productDetailCompact.price.toString())
        tv_detail_title.text = productDetailCompact.productName
    }
}