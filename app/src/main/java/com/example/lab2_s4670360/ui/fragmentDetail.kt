package com.example.lab2_s4670360.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.lab2_s4670360.R
import dagger.hilt.android.AndroidEntryPoint

// Enable Hilt injection
@AndroidEntryPoint
class fragmentDetail : Fragment() {

    // Retrieve the arguments passed from the previous fragment using SafeArgs
    private val args: fragmentDetailArgs by navArgs()

    // Inflate the layout for the fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    // Populate the TextView with the data passed via arguments
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the TextView by its ID
        val detailTextView = view.findViewById<TextView>(R.id.detail)

        // Retrieve and format the data from the arguments
        val eventDetails = """
            Event: ${args.event}
            Start Year: ${args.startYear}
            End Year: ${args.endYear}
            Location: ${args.location}
            Key Figure: ${args.keyFigure}
            Description: ${args.detail}
        """.trimIndent()

        // Set the text in the TextView
        detailTextView.text = eventDetails
    }
}
