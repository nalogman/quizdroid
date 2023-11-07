package edu.uw.ischool.nalogman.quizdroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TopicOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)

        val selectedTopic = intent.getSerializableExtra("selectedTopic") as Topic

        val topicNameTextView: TextView = findViewById(R.id.topicNameTextView)
        val topicDescriptionTextView: TextView = findViewById(R.id.topicDescriptionTextView)
        val totalQuestionsTextView: TextView = findViewById(R.id.totalQuestionsTextView)
        val beginButton: Button = findViewById(R.id.beginButton)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        val longDescription = intent.getStringExtra("longDescription") // Retrieve long description

        topicNameTextView.text = selectedTopic.name
        topicDescriptionTextView.text = selectedTopic.longDescription
        totalQuestionsTextView.text = getString(R.string.total_questions, totalQuestions)

        beginButton.setOnClickListener {
            // Handle Begin button click, navigate to QuestionActivity
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("selectedTopic", selectedTopic)
            intent.putExtra("questionNumber", 1) // Assuming it's the first question
            intent.putExtra("totalQuestions",totalQuestions)
            startActivity(intent)
        }
    }
}