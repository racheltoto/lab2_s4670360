package com.example.lab2_s4670360.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2_s4670360.R
import com.example.lab2_s4670360.data.ResponseItem
import com.example.lab2_s4670360.recyclerview.HistoryAdapter
import com.example.lab2_s4670360.viewmodel.DashVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// Purpose:
// - Dashboard fragment to display a list of artworks using a RecyclerView
// - Uses a ViewModel to fetch and observe the list of artworks
// - Binds the artwork data to the RecyclerView using ArtAdapter

// Enable Hilt injection
@AndroidEntryPoint
class fragmentDashboard : Fragment() {

    // Initialized Dependency Injections
    private val dashboardViewModel: DashVM by viewModels()
    private lateinit var historyAdapter: HistoryAdapter

    // Use the fragment_dashboard xml
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    // All the logic happen here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define the navigation function lambda using safeArgs
        // Lambda is like passing a parameter in Java
        val navigationFunctionLambda: (ResponseItem) -> Unit = { history ->

            // Use safeArgs to navigate to details fragment, passing the artwork data
//            val action = fragmentDashboardDirections.actionFragmentDashboardToFragmentDetail(
//                event = history.eventName,
//                startYear = history.startYear,
//                endYear = history.endYear,
//                location = history.location,
//                keyFigure = history.keyFigure,
//                detail = history.description
//            )
//
//            // Navigate to action (Details)
//            findNavController().navigate(action)
        }

        // Initialize recyclerViews from the fragment_dashboard ID
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // initialized artAdapter and pass function navigate lambda when clicked
        historyAdapter = HistoryAdapter(navigationFunction = navigationFunctionLambda)

        // Connect ArtAdapter to RecyclerView to displays data
        recyclerView.adapter = historyAdapter

        // Collect the artworkEntities flow and update RecyclerView
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                dashboardViewModel.artworkEntities.collect { artworks ->
                    historyAdapter.submitList(artworks)
                    // submitList -> in  ArtAdapter
                }
            }
        }

        // Fetch the artworks when the fragment is created
        dashboardViewModel.fetchArtworks()
    }
}

