package com.example.projetesiea.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetesiea.R
import com.example.projetesiea.presentation.list.Players.Players
import com.example.projetesiea.presentation.list.api.NbaPlayers

class NBAAdapter(private var dataSet: List<NbaPlayers>, var listener: ((NbaPlayers) -> Unit)? = null) : RecyclerView.Adapter<NBAAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val LastNametextView: TextView
        val AbbreviationtextView : TextView


        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.first_name)
            LastNametextView = view.findViewById(R.id.last_name)
            AbbreviationtextView = view.findViewById(R.id.abbreviation)



        }

    }

    fun updateList(list: List<NbaPlayers>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.shoes_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val nbaPlayers : NbaPlayers = dataSet[position]


        viewHolder.textView.text = nbaPlayers.first_name
        viewHolder.LastNametextView.text = nbaPlayers.last_name
        viewHolder.AbbreviationtextView.text = nbaPlayers.team.abbrevation

        viewHolder.itemView.setOnClickListener {
            listener?.invoke(nbaPlayers)
        }


    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}