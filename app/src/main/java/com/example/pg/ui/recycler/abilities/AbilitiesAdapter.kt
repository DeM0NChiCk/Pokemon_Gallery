package com.example.pg.ui.recycler.abilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemInfoBinding
import com.example.pg.ui.model.PokemonAbilityDataModel

class AbilitiesAdapter(
    private val list: List<PokemonAbilityDataModel>
): RecyclerView.Adapter<AbilitiesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesHolder =
        AbilitiesHolder(
            ItemInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AbilitiesHolder, position: Int) {
        holder.bind(list, position)
    }
}