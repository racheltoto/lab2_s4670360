package com.example.lab2_s4670360.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2_s4670360.R
import com.example.lab2_s4670360.data.ResponseItem

// Purpose:
// Adapter handle the display of history data in a RecyclerView
// Responsible for creating ViewHolder instances and binding data to the RecyclerView

// Implementations:
// RecyclerView xml layout (fragment_dashboard)
// xml layout for ViewHolder (item_layout_restful_api_service xml)
// Create Adapter
// Create ViewHolder class
// ViewModel -> to manage data flow
// Set data in fragment

// Adapter class to manage the history data
class HistoryAdapter(
    private var historyList: List<ResponseItem> = emptyList(),

    private val navigationFunction: (ResponseItem) -> Unit) :

    RecyclerView.Adapter<HistoryHolder>() {

    // Creates new VideHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        // Using the item_layout_restful_api_service xml
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_restful_api_dev, parent, false)
        return HistoryHolder(view)
    }

    // Binds the data to ViewHolder
    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        // Fetch the art item index
        val artwork = historyList[position]
        // Call bind to set the item data
        holder.bind(artwork)

        // Find the button in the item layout and set a click listener
        holder.itemView.findViewById<Button>(R.id.navigationButton).setOnClickListener {
            navigationFunction(artwork) // Pass the clicked artwork to the lambda
        }
    }

    // Returns a total number of the items
    override fun getItemCount(): Int {
        return historyList.size
    }

    // Update the list of artwork entities and notify the adapter
    @SuppressLint("NotifyDataSetChanged")
    fun submitList(artworks: List<ResponseItem>) {
        historyList = artworks
        notifyDataSetChanged()
    }
}
