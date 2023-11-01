package edu.uw.ischool.nalogman.quizdroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnswerActivity : AppCompatActivity() {

    companion object {
        var totalCorrect = 0
    }
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
        val finishButton: Button = findViewById(R.id.finishButton)



        // Display user's answer
        val userAnswerText = "Your Answer: ${question.options[selectedAnswerIndex]}"
        answerTextView.text = userAnswerText

        // Display correct answer
        val correctAnswerText = "Correct Answer: ${question.options[question.correctAnswerIndex]}"
        correctAnswerTextView.text = correctAnswerText

        // Check if the user's answer is correct
        val isCorrect = selectedAnswerIndex == question.correctAnswerIndex
        if (isCorrect) {
            totalCorrect++
        }
        val resultText = if (isCorrect) "Correct!" else "Incorrect!"
        val message = "You have $totalCorrect out of $totalQuestions correct."
        resultTextView.text = resultText + "\n" + message


        if (questionNumber <= totalQuestions) {
            nextButton.visibility = View.VISIBLE
            finishButton.visibility = View.GONE
            nextButton.setOnClickListener {
                // Increment the question number
                Log.d("AnswerActivity", "Current Question: $questionNumber, Next Question: lol")
                    val nextIntent = Intent(this, QuestionActivity::class.java)
                    nextIntent.putExtra("selectedTopic", selectedTopic)
                    nextIntent.putExtra("questionNumber", questionNumber)
                    nextIntent.putExtra("totalQuestions",totalQuestions)
                    startActivity(nextIntent)
                    finish()
                }
        } else {
            nextButton.visibility = View.GONE
            finishButton.visibility = View.VISIBLE
            finishButton.setOnClickListener{
                // Finish the quiz and go back to TopicListActivity
                totalCorrect = 0
                val finishIntent = Intent(this, TopicListActivity::class.java)
                startActivity(finishIntent)
                finish()
            }
        }

    }
}