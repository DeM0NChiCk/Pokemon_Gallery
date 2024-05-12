package com.example.pg.ui.recycler.shimmer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemListShimmerBinding
import com.github.terrakok.cicerone.Router

class ShimmerListAdapter (
    private val list:List<String>,
): RecyclerView.Adapter<ShimmerListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShimmerListHolder =
        ShimmerListHolder(
            ItemListShimmerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ShimmerListHolder, position: Int) {
        holder.bind(list, position)
    }
}