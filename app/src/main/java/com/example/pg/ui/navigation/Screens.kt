package com.example.pg.ui.navigation

import android.os.Bundle
import com.example.pg.ui.screen.fragment.InfoFragment
import com.example.pg.ui.screen.fragment.ListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun List() = FragmentScreen { ListFragment() }
    fun Info(bundle: Bundle) = FragmentScreen {
        val fragment = InfoFragment()
        fragment.arguments = bundle
        return@FragmentScreen fragment
    }
}