package com.example.listevent.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listevent.R
import com.example.listevent.model.Event
import kotlinx.android.synthetic.main.item_event.view.*


class ListEventAdapter(
    private val context: Context,
    private val events: MutableList<Event> = mutableListOf(),
    var click: (event: Event) -> Unit = {}
) : RecyclerView.Adapter<ListEventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(
                R.layout.item_event,
                parent, false
            )
        return ViewHolder(view)
    }

    override fun getItemCount() = events.size

    fun atualiza(events: List<Event>) {
        notifyItemRangeRemoved(0, this.events.size)
        this.events.clear()
        this.events.addAll(events)
        notifyItemRangeInserted(0, this.events.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]
        holder.onLoad(event)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var event: Event

        init {
            itemView.setOnClickListener {
                if (::event.isInitialized) {
                    click(event)
                }
            }
        }

        fun onLoad(event: Event) {
            this.event = event
            itemView.item_name.text = event.name
            itemView.item_email.text = event.email
        }

    }

}
