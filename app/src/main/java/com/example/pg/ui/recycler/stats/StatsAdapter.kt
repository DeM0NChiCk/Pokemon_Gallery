package com.example.pg.ui.recycler.stats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemInfoBinding
import com.example.pg.ui.model.PokemonStatsDataModel

class StatsAdapter (
    private val list: List<PokemonStatsDataModel>
): RecyclerView.Adapter<StatsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsHolder =
        StatsHolder(
            ItemInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StatsHolder, position: Int) {
        holder.bind(list, position)
    }
}