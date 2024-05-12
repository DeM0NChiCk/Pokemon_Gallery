package com.example.pg.ui.recycler.types

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemInfoBinding
import com.example.pg.ui.model.PokemonTypeDataModel
import com.example.pg.ui.recycler.abilities.AbilitiesHolder

class TypesAdapter (
    private val list: List<PokemonTypeDataModel>
): RecyclerView.Adapter<TypesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesHolder =
        TypesHolder(
            ItemInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TypesHolder, position: Int) {
        holder.bind(list, position)
    }
}