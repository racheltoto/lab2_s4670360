package com.example.lab2_s4670360.recyclerview

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2_s4670360.R
import com.example.lab2_s4670360.data.ResponseItem

// Purpose:
// - Holds references to the views for each RecyclerView item
// - Binds artwork data to these views

// ViewHolder class to hold references to views for each item
class HistoryHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Right: is from the item_layout_restful_api_dev
    // Left: is a declared values
    private val event: TextView = view.findViewById(R.id.event)
    private val startYear: TextView = view.findViewById(R.id.startYear)
    private val endYear: TextView = view.findViewById(R.id.endYear)
    private val slocation = view.findViewById<TextView>(R.id.location)
    private val skeyFigure: TextView = view.findViewById(R.id.keyFigure)
    // Bind the data to the views
    @SuppressLint("SetTextI18n")

    // Right: is from the ArtworkEntity Class
    // Left: if from initialize item up there
    fun bind(history: ResponseItem) {
        event.text = history.eventName
        startYear.text = "Start year: ${history.startYear}"
        endYear.text = "End year: ${history.startYear}"
        slocation.text = history.location
        skeyFigure.text = history.keyFigure
    }
}
