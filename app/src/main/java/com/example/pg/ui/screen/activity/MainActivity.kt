package com.example.pg.ui.screen.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pg.PokemonApp
import com.example.pg.R
import com.example.pg.databinding.ActivityMainBinding
import com.example.pg.ui.navigation.Screens
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    val router = PokemonApp.router
    val navigatorHolder = PokemonApp.navigatorHolder

    private val navigator = AppNavigator(this, R.id.container_fragment_in_activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

//        when {
//            supportActionBar != null -> {
//                supportActionBar?.hide()
//            }
//            getActionBar() != null -> {
//                getActionBar()?.hide()
//            }
//        }

//        enableEdgeToEdge()

        if (savedInstanceState == null) {
            router.newRootScreen(Screens.List())
        }


        binding?.apply {
//            ViewCompat.setOnApplyWindowInsetsListener(main) { v, insets ->
//                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//                insets
//            }
            setContentView(root)
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            val controller =  window.insetsController
//
//            controller?.hide(WindowInsets.Type.statusBars())
//
//            controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//        } else {
//            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}