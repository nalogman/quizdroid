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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.bind(topic)
        holder.itemView.setOnClickListener { onItemClick(topic) }
    }

    override fun getItemCount(): Int = topics.size

    inner class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val topicNameTextView: TextView = itemView.findViewById(R.id.topicNameTextView)

        fun bind(topic: Topic) {
            topicNameTextView.text = topic.name
        }
    }
}