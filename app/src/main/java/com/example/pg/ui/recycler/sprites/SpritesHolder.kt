package com.example.pg.ui.recycler.sprites

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pg.databinding.ItemSpritesBinding

class SpritesHolder(
    private val binding: ItemSpritesBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        list: List<String>,
        position: Int
    ) {
        binding.apply {
            Glide.with(root.context)
                .load(list[position])
                .into(imageSprite)
        }
    }
}