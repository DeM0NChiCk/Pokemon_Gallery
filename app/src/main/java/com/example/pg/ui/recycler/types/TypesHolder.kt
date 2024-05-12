package com.example.pg.ui.recycler.types

import androidx.recyclerview.widget.RecyclerView
import com.example.pg.R
import com.example.pg.databinding.ItemInfoBinding
import com.example.pg.ui.model.PokemonTypeDataModel

class TypesHolder (
    private val binding: ItemInfoBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind (
        list: List<PokemonTypeDataModel>,
        position: Int
    ) {
        binding.apply {
            val typeName: String = list[position].type.name
            val typeSlot: String = list[position].slot.toString()
            tvInfoPokemon.text = root.context.getString(R.string.type_text, typeName, typeSlot)
        }
    }
}