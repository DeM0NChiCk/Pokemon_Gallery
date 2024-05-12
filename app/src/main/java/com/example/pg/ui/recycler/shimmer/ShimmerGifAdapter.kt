package com.example.pg.ui.recycler.shimmer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemSpritesGifShimmerBinding
import com.example.pg.databinding.ItemSpritesShimmerBinding

class ShimmerGifAdapter (
    private val list:List<String>,
): RecyclerView.Adapter<ShimmerGifHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShimmerGifHolder =
        ShimmerGifHolder(
            ItemSpritesGifShimmerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ShimmerGifHolder, position: Int) {
        holder.bind(list, position)
    }
}