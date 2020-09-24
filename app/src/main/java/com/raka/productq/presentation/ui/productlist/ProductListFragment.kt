package com.raka.productq.presentation.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.raka.productq.R
import com.raka.productq.data.model.ProductListCompact
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_product_list.*

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private val viewModel: ProductListViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductListAdapter
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView: View
        val isTablet = context!!.resources.getBoolean(R.bool.isTablet)
        when {
            isTablet -> {
                mView = inflater.inflate(R.layout.fragment_list_tablet, container, false)
                navHostFragment =
                    childFragmentManager.findFragmentById(R.id.fragment_detail_container) as NavHostFragment
                navHostFragment.navController.navigate(R.id.product_detail_tablet)
            }
            else -> {
                mView = inflater.inflate(R.layout.fragment_product_list, container, false)
                navHostFragment = NavHostFragment()
            }
        }
        recyclerView = mView.findViewById(R.id.rv_product)
        adapter = ProductListAdapter()
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
        recyclerView.adapter = adapter
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupAdapter()
        viewModel.getProductListData()
    }

    private fun setupAdapter() {
        adapter = ProductListAdapter()
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
        recyclerView.adapter = adapter
    }

    private fun showNoData() {
        tv_list_no_data.visibility = View.VISIBLE
    }

    private fun setData(list: List<ProductListCompact>) {
        adapter.updateData(list.toMutableList(), navHostFragment)
        iv_banner.load(list[0].banner) {
            placeholder(R.drawable.ic_baseline_emoji_emotions_24)
            placeholder(R.drawable.ic_baseline_error_24)
        }
        recyclerView.visibility = View.VISIBLE
        iv_banner.visibility = View.VISIBLE
    }

    private fun setupObserver() {
        viewModel.productList.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                setData(it)
            } else {
                showNoData()
            }
        })
    }
}