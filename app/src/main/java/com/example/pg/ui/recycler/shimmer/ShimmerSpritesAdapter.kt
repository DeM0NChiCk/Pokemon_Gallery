package com.example.pg.ui.recycler.shimmer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemSpritesShimmerBinding

class ShimmerSpritesAdapter (
    private val list:List<String>,
): RecyclerView.Adapter<ShimmerSpritesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShimmerSpritesHolder =
        ShimmerSpritesHolder(
            ItemSpritesShimmerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ShimmerSpritesHolder, position: Int) {
        holder.bind(list, position)
    }
}