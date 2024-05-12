package com.example.pg

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class PokemonApp: Application() {
    companion object {
        private val cicerone = Cicerone.create()

        val router get() = cicerone.router

        val navigatorHolder get() = cicerone.getNavigatorHolder()
    }
}