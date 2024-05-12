package com.example.pg.ui.recycler.sprites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemSpritesBinding

class SpritesAdapter(
    private val list: List<String>
): RecyclerView.Adapter<SpritesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpritesHolder =
        SpritesHolder(
            ItemSpritesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SpritesHolder, position: Int) {
        holder.bind(list, position)
    }
}