package com.example.pg.ui.recycler.sprites_gif

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemSpritesGifBinding
import com.example.pg.ui.recycler.sprites.SpritesHolder

class SpritesGifAdapter(
    private val list: List<String>
): RecyclerView.Adapter<SpritesGifHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpritesGifHolder =
        SpritesGifHolder(
            ItemSpritesGifBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SpritesGifHolder, position: Int) {
        holder.bind(list, position)
    }
}