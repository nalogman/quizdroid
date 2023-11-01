package edu.uw.ischool.nalogman.quizdroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnswerActivity : AppCompatActivity() {

    private val TAG = "AnswerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val userAnswer = intent.getSerializableExtra("userAnswer") as UserAnswer
        val question = userAnswer.question
        val selectedAnswerIndex = userAnswer.selectedAnswerIndex
        val selectedTopic = intent.getSerializableExtra("selectedTopic") as Topic
        val totalQuestions = intent.getIntExtra("totalQuestions", 5)
        val questionNumber = intent.getIntExtra("questionNumber", 1)
        val answerTextView: TextView = findViewById(R.id.answerTextView)
        val correctAnswerTextView: TextView = findViewById(R.id.correctAnswerTextView)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val nextButton: Button = findViewById(R.id.nextButton)

        // Display user's answer
        val userAnswerText = "Your Answer: ${question.options[selectedAnswerIndex]}"
        answerTextView.text = userAnswerText

        // Display correct answer
        val correctAnswerText = "Correct Answer: ${question.options[question.correctAnswerIndex]}"
        correctAnswerTextView.text = correctAnswerText

        // Check if the user's answer is correct
        val isCorrect = selectedAnswerIndex == question.correctAnswerIndex
        val resultText = if (isCorrect) "Correct!" else "Incorrect!"
        resultTextView.text = resultText

        nextButton.setOnClickListener {
            // Increment the question number
            Log.d("AnswerActivity", "Current Question: $questionNumber, Next Question: lol")
            if (questionNumber <= totalQuestions) {
                // Proceed to the next question
                val nextIntent = Intent(this, QuestionActivity::class.java)
                nextIntent.putExtra("selectedTopic", selectedTopic)
                nextIntent.putExtra("questionNumber", questionNumber)
                intent.putExtra("totalQuestions",totalQuestions)
                startActivity(nextIntent)
                finish()
            } else {
                // Finish the quiz and go back to TopicListActivity
                val finishIntent = Intent(this, TopicListActivity::class.java)
                startActivity(finishIntent)
                finish()
            }
        }
    }
}