package edu.uw.ischool.nalogman.quizdroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicListAdapter(
    private val topics: List<Topic>,
    private val onItemClick: (Topic) -> Unit
) : RecyclerView.Adapter<TopicListAdapter.TopicViewHolder>() {

    inner class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.topic_list_item, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val currentTopic = topics[position]

        holder.titleTextView.text = currentTopic.name
        holder.descriptionTextView.text = currentTopic.description

        holder.itemView.setOnClickListener {
            onItemClick(currentTopic)
        }
    }

    override fun getItemCount(): Int {
        return topics.size
    }
}