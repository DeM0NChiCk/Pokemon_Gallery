package com.example.pg.ui.recycler.abilities

import androidx.recyclerview.widget.RecyclerView
import com.example.pg.R
import com.example.pg.databinding.ItemInfoBinding
import com.example.pg.ui.model.PokemonAbilityDataModel

class AbilitiesHolder(
    private val binding: ItemInfoBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind (
        list: List<PokemonAbilityDataModel>,
        position: Int
    ) {
        binding.apply {
            val abilityName: String = list[position].ability.name
            val abilitySlot: String = list[position].slot.toString()
            val abilityHidden: String = list[position].isHidden.toString()
            tvInfoPokemon.text = root.context.getString(R.string.ability_text, abilityName, abilitySlot, abilityHidden)
        }
    }
}