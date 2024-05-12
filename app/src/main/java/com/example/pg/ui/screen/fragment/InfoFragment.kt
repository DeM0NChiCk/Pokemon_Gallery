package com.example.pg.ui.screen.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.pg.R
import com.example.pg.databinding.FragmentInfoBinding
import com.example.pg.di.DiContainer
import com.example.pg.ui.enums.ConstValue
import com.example.pg.ui.mvi.MviBaseFragment
import com.example.pg.ui.mvi.MviStore
import com.example.pg.ui.recycler.abilities.AbilitiesAdapter
import com.example.pg.ui.recycler.shimmer.ShimmerGifAdapter
import com.example.pg.ui.recycler.shimmer.ShimmerListAdapter
import com.example.pg.ui.recycler.shimmer.ShimmerSpritesAdapter
import com.example.pg.ui.recycler.sprites.SpritesAdapter
import com.example.pg.ui.recycler.sprites_gif.SpritesGifAdapter
import com.example.pg.ui.recycler.stats.StatsAdapter
import com.example.pg.ui.recycler.types.TypesAdapter
import com.example.pg.ui.screen.mvi.info.InfoEffect
import com.example.pg.ui.screen.mvi.info.InfoIntent
import com.example.pg.ui.screen.mvi.info.InfoPartialState
import com.example.pg.ui.screen.mvi.info.InfoState
import com.example.pg.ui.utils.LceState

class InfoFragment : MviBaseFragment<
        InfoPartialState,
        InfoIntent,
        InfoState,
        InfoEffect
        >(R.layout.fragment_info) {

    override val store: MviStore<
            InfoPartialState,
            InfoIntent,
            InfoState,
            InfoEffect> by viewModels { DiContainer.infoStoreFactory }


    private var binding: FragmentInfoBinding? = null

    override fun resolveEffect(effect: InfoEffect) {
        when (effect) {
            is InfoEffect.ShowError -> showErrorDialog(effect.throwable.message, pokemonName)
            is InfoEffect.ShowShimmer -> {
                if (effect.boolean) {
                    binding?.apply {
                        shimmerTvTitleNameShimmer.startShimmer()
                        shimmerRecyclerPokemonFragmentInfo.startShimmer()

                        shimmerTvTitleNameShimmer.visibility = View.VISIBLE
                        nestedScrollViewFragmentShimmer.visibility = View.VISIBLE
                        nestedScrollViewFragment.visibility = View.GONE

                        recyclerPokemonAbilitiesShimmer.adapter = ShimmerListAdapter(ConstValue.LIST_SHIMMER_INFO)
                        recyclerPokemonStatsShimmer.adapter = ShimmerListAdapter(ConstValue.LIST_SHIMMER_INFO)
                        recyclerPokemonTypesShimmer.adapter = ShimmerListAdapter(ConstValue.LIST_SHIMMER_INFO)
                        recyclerPokemonSpritesShimmer.adapter = ShimmerSpritesAdapter(ConstValue.LIST_SHIMMER_SPRITE)
                        recyclerPokemonSpritesGifShimmer.adapter = ShimmerGifAdapter(ConstValue.LIST_SHIMMER_SPRITE)
                    }
                } else {
                    binding?.apply {
                        shimmerTvTitleNameShimmer.stopShimmer()
                        shimmerRecyclerPokemonFragmentInfo.stopShimmer()

                        shimmerTvTitleNameShimmer.visibility = View.GONE
                        nestedScrollViewFragmentShimmer.visibility = View.GONE
                        nestedScrollViewFragment.visibility = View.VISIBLE

                    }
                }
            }

        }
    }

    private var pokemonName: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)

        pokemonName = arguments?.getString("pokemonName", null) ?: return

        resolveEffect(InfoEffect.ShowShimmer(true))

        if (savedInstanceState == null) {
            store.postIntent(InfoIntent.Init(pokemonName))
        }

    }

    override fun render(state: InfoState) {
        when (val dataToRenderer = state.pokemonDataModel) {
            is LceState.Content -> {
                val data = dataToRenderer.content
                resolveEffect(InfoEffect.ShowShimmer(false))
                binding?.apply {
                    tvTitleName.text = data.name
                    tvWeight.text = getString(R.string.weight, data.weight.toString())
                    tvHeight.text = getString(R.string.height, data.height.toString())
                    tvBaseExperience.text = getString(R.string.base_experience, data.baseExperience.toString())
                    val listSprites = listOfNotNull(
                        data.sprites.backDefault,
                        data.sprites.backFemale,
                        data.sprites.backShiny,
                        data.sprites.backShinyFemale,
                        data.sprites.frontDefault,
                        data.sprites.frontFemale,
                        data.sprites.frontShiny,
                        data.sprites.frontShinyFemale
                    ).filter { it.isNotEmpty() }

                    Log.e("CHECKER", listSprites[0])

                    recyclerPokemonSprites.adapter = SpritesAdapter(listSprites)

                    val listGif = listOfNotNull(
                        data.sprites.other.showdown.backDefault,
                        data.sprites.other.showdown.backFemale,
                        data.sprites.other.showdown.backShiny,
                        data.sprites.other.showdown.backShinyFemale,
                        data.sprites.other.showdown.frontDefault,
                        data.sprites.other.showdown.frontFemale,
                        data.sprites.other.showdown.frontShiny,
                        data.sprites.other.showdown.frontShinyFemale
                    ).filter { it.isNotEmpty() }

                    recyclerPokemonSpritesGif.adapter = SpritesGifAdapter(listGif)

                    val listAbility = data.abilities

                    recyclerPokemonAbilities.adapter = AbilitiesAdapter(listAbility)

                    val listType = data.types

                    recyclerPokemonTypes.adapter = TypesAdapter(listType)

                    val listStats = data.stats

                    recyclerPokemonStats.adapter = StatsAdapter(listStats)
                }
            }

            is LceState.Error -> Unit
            LceState.Loading -> Unit
        }
    }

    private fun showErrorDialog(errorMessage: String?, name: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.error_title)
            .setMessage(errorMessage)
            .setPositiveButton(getText(R.string.retry_button)) { dialog, which ->
                store.postIntent(InfoIntent.Init(name))
            }
            .setCancelable(false)
            .show()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }


}