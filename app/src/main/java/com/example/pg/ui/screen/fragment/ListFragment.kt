package com.example.pg.ui.screen.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.pg.PokemonApp
import com.example.pg.R
import com.example.pg.databinding.FragmentListBinding
import com.example.pg.di.DiContainer
import com.example.pg.ui.enums.ConstValue.LIST_SHIMMER
import com.example.pg.ui.model.ResultDataModel
import com.example.pg.ui.mvi.MviBaseFragment
import com.example.pg.ui.mvi.MviStore
import com.example.pg.ui.recycler.list.ListAdapter
import com.example.pg.ui.recycler.shimmer.ShimmerListAdapter
import com.example.pg.ui.screen.mvi.list.ListEffect
import com.example.pg.ui.screen.mvi.list.ListIntent
import com.example.pg.ui.screen.mvi.list.ListPartialState
import com.example.pg.ui.screen.mvi.list.ListState
import com.example.pg.ui.utils.LceState

class ListFragment
    : MviBaseFragment<
        ListPartialState,
        ListIntent,
        ListState,
        ListEffect
        >(R.layout.fragment_list) {

    override val store: MviStore<
            ListPartialState,
            ListIntent,
            ListState,
            ListEffect> by viewModels { DiContainer.listStoreFactory }

    private var binding: FragmentListBinding? = null

    private val router = PokemonApp.router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        resolveEffect(ListEffect.ShowShimmer(true))
        if (savedInstanceState == null) {
            store.postIntent(ListIntent.Init)
        }

    }

    override fun resolveEffect(effect: ListEffect) {
        when (effect) {
            is ListEffect.ShowError -> showErrorDialog(effect.throwable.message)
            is ListEffect.ShowShimmer -> {
                if (effect.boolean) {
                    binding?.apply {
                        recyclerPokemonFragmentShimmer.adapter = ShimmerListAdapter(LIST_SHIMMER)
                        shimmerRecyclerPokemonFragment.startShimmer()
                        shimmerRecyclerPokemonFragment.visibility = View.VISIBLE
                        recyclerPokemonFragment.visibility = View.GONE
                    }
                } else {
                    binding?.apply {
                        shimmerRecyclerPokemonFragment.stopShimmer()
                        shimmerRecyclerPokemonFragment.visibility = View.GONE
                        recyclerPokemonFragment.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun render(state: ListState) {
        when (val dataToRenderer = state.pokemonListDataModel) {
            is LceState.Content -> {
                resolveEffect(ListEffect.ShowShimmer(false))
                val data = dataToRenderer.content
                binding?.apply {
                    recyclerPokemonFragment.adapter = ListAdapter(data.results, router)
                    btnPreviousPage.isVisible = state.offset >= 30
                    btnNextPage.isVisible = state.offset <= 1260
                    btnPreviousPage.setOnClickListener {
                        store.postIntent(ListIntent.PreviousPage)
                    }
                    btnNextPage.setOnClickListener {
                        store.postIntent(ListIntent.NextPage)
                    }
                }
            }

            is LceState.Error -> Unit
            LceState.Loading -> Unit
        }
    }

    private fun showErrorDialog(errorMessage: String?) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.error_title)
            .setMessage(errorMessage)
            .setPositiveButton(getText(R.string.retry_button)) { dialog, which ->
                store.postIntent(ListIntent.Init)
            }
            .setCancelable(false)
            .show()
    }

    override fun onDestroyView() {
        store.postIntent(ListIntent.NextPage)
        binding = null
        super.onDestroyView()
    }

}