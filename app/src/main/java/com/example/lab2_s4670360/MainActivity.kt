package com.example.lab2_s4670360

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

//s4670360
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set up window insets handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize NavHostFragment and NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        // Initialize BottomNavigationView with the correct ID from the XML
        bottomNavBar = findViewById(R.id.bottom_navbar)

        // Set up BottomNavigationView with NavController
        bottomNavBar.setupWithNavController(navController)

        // Set up bottom navigation item selection
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottomNavBar.setOnItemSelectedListener { item ->
            if (item.itemId != bottomNavBar.selectedItemId) {
                val fragmentId = when (item.itemId) {
                    R.id.navigation_dashboard -> R.id.fragmentDashboard
                    R.id.navigation_detail -> R.id.fragmentDetail
                    else -> R.id.fragmentLogin
                }
                navController.popBackStack(navController.graph.startDestinationId, inclusive = false)
                navController.navigate(fragmentId)
            }
            true
        }
    }
}
