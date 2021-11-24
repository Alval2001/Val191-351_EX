package com.dev.exam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.exam.databinding.EventBinding

class EventsAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = EventBinding.bind(itemView)
        fun bind(row: Event) = with(binding)
        {
            header.text = row.header
            date.text = row.date
            val path = root.resources.getIdentifier(row.img,"drawable",root.context.packageName)
            img.setImageResource(path)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount() = events.size

}