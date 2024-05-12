package com.example.pg.ui.recycler.shimmer

import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemSpritesGifShimmerBinding

class ShimmerGifHolder (
    private val binding: ItemSpritesGifShimmerBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        list: List<String>,
        position: Int
    ) {
        binding.apply {
            imageSpriteGif.text = list[position]
        }
    }
}