package com.example.pg.ui.recycler.shimmer

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemListBinding
import com.example.pg.databinding.ItemListShimmerBinding
import com.example.pg.ui.model.ResultDataModel
import com.example.pg.ui.navigation.Screens
import com.github.terrakok.cicerone.Router

class ShimmerListHolder (
    private val binding: ItemListShimmerBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        list: List<String>,
        position: Int
    ) {
        binding.apply {
            tvShimmerPokemon.text = list[position]
        }
    }
}