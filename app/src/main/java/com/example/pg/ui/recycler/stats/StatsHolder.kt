package com.example.pg.ui.recycler.stats

import androidx.recyclerview.widget.RecyclerView
import com.example.pg.R
import com.example.pg.databinding.ItemInfoBinding
import com.example.pg.ui.model.PokemonStatsDataModel

class StatsHolder (
    private val binding: ItemInfoBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind (
        list: List<PokemonStatsDataModel>,
        position: Int
    ) {
        binding.apply {
            val statName: String = list[position].stat.name
            val statBase: String = list[position].baseStat.toString()
            val statEffort: String = list[position].effort.toString()
            tvInfoPokemon.text = root.context.getString(R.string.stat_text, statName, statBase, statEffort)
        }
    }
}