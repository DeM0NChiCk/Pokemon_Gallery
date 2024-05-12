package com.example.pg.ui.recycler.sprites_gif

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pg.databinding.ItemSpritesGifBinding

class SpritesGifHolder (
    private val binding: ItemSpritesGifBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        list: List<String>,
        position: Int
    ) {
        binding.apply {
            Glide.with(root.context)
                .asGif()
                .load(list[position])
                .into(imageSpriteGif)
        }
    }
}