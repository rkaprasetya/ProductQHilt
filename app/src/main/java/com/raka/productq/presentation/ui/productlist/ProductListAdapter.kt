package com.raka.productq.presentation.ui.productlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raka.productq.R
import com.raka.productq.data.model.ProductListCompact
import kotlinx.android.synthetic.main.item_list.view.*

class ProductListAdapter:RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {
    var list: MutableList<ProductListCompact> = mutableListOf()
    var navHostFragment = NavHostFragment()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_list, parent, false)
        return ProductListViewHolder(
            itemView, navHostFragment
        )
    }

    override fun getItemCount() = list.size
    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    class ProductListViewHolder(itemView: View, val navHostFragment: NavHostFragment) :
        RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: ProductListCompact) {
            Glide.with(itemView).load(item.thumbnail).into(itemView.iv_item_list)
            itemView.tv_item_name.text = item.productName
            itemView.tv_item_stok_number.text = item.stock.toString()
            itemView.tv_item_price.text =
                itemView.context.getString(R.string.item_price, item.price.toString())
            val isTablet = itemView.context.resources.getBoolean(R.bool.isTablet)
            val bundle = bundleOf("id" to item.productId)
            when {
                isTablet -> {
                    itemView.setOnClickListener {
                        navHostFragment.findNavController()
                            .navigate(R.id.product_detail_tablet, bundle)
                    }
                }
                else -> {
                    itemView.setOnClickListener {
                        it.findNavController().navigate(
                            R.id.action_productListFragment_to_productDetailFragment,
                            bundle
                        )
                    }
                }
            }
        }
    }

    fun updateData(data: MutableList<ProductListCompact>, navHostFragment: NavHostFragment) {
        this.list.addAll(data)
        this.navHostFragment = navHostFragment
        notifyDataSetChanged()
    }
}