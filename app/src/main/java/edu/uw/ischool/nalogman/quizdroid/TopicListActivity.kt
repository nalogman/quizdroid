package edu.uw.ischool.nalogman.quizdroid


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TopicListActivity : AppCompatActivity() {

    private lateinit var topicRepository: TopicRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_list)

        // Initialize the repository
        topicRepository = QuizApp.topicRepository

        val recyclerView: RecyclerView = findViewById(R.id.topicRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get the list of topics from the repository
        val topics = topicRepository.getAllTopics()

        // Set up the RecyclerView with the TopicListAdapter
        recyclerView.adapter = TopicListAdapter(topics) { selectedTopic ->
            // Handle the click event
            val intent = Intent(this, TopicOverviewActivity::class.java)
            intent.putExtra("selectedTopic", selectedTopic)
            intent.putExtra("totalQuestions", selectedTopic.questions.size)
            startActivity(intent)
        }
    }
}