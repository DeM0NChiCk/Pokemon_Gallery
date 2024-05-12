package com.example.pg.ui.recycler.list

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemListBinding
import com.example.pg.ui.model.ResultDataModel
import com.example.pg.ui.navigation.Screens
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen

class ListHolder(
    private val binding: ItemListBinding,
    private val router: Router
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        list: List<ResultDataModel>,
        position: Int
    ) {
        binding.apply {
            val pokemonName = list[position].name
            tvNamePokemon.text = pokemonName

            root.setOnClickListener {
                val bundle = Bundle().apply {
                    putString("pokemonName", pokemonName)
                }

                router.navigateTo(Screens.Info(bundle))
            }
        }
    }
}