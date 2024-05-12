package com.example.pg.ui.recycler.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.databinding.ItemListBinding
import com.example.pg.ui.model.ResultDataModel
import com.github.terrakok.cicerone.Router

class ListAdapter(
    private val list:List<ResultDataModel>,
    private val router: Router
): RecyclerView.Adapter<ListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder =
        ListHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            router
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(list, position)
    }
}