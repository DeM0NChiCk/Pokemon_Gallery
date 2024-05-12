package com.example.pg.ui.recycler.shimmer

import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemSpritesShimmerBinding

class ShimmerSpritesHolder (
    private val binding: ItemSpritesShimmerBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        list: List<String>,
        position: Int
    ) {
        binding.apply {
            imageSprite.text = list[position]
        }
    }
}