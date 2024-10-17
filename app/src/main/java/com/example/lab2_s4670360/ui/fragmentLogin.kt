package com.example.lab2_s4670360.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.lab2_s4670360.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class fragmentLogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle edge-to-edge display adjustments
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button after the view is created
        val myButton: Button = view.findViewById(R.id.loginButton)

        // Set up click listener for the login button
        myButton.setOnClickListener {
            // Call the function to navigate to the dashboard
            navigateToDashboard()
        }
    }

    private fun navigateToDashboard() {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.fragmentLogin, true) // Removes login fragment from back stack
            .build()

        // Move from login to dashboard
        findNavController().navigate(R.id.action_fragmentLogin_to_fragmentDashboard, null, navOptions)

        // Update the BottomNavigationView to reflect the change
        activity?.findViewById<BottomNavigationView>(R.id.bottom_navbar)?.selectedItemId = R.id.navigation_dashboard
    }
}
