package edu.uw.ischool.nalogman.quizdroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val selectedTopic = intent.getSerializableExtra("selectedTopic") as Topic
        val questionNumber = intent.getIntExtra("questionNumber", 1)
        val question = selectedTopic.questions[questionNumber - 1]
        val totalQuestions = selectedTopic.totalQuestions
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val submitButton: Button = findViewById(R.id.submitButton)

        questionTextView.text = question.questionText

        for (i in question.options.indices) {
            val radioButton = RadioButton(this)
            radioButton.text = question.options[i]
            radioGroup.addView(radioButton)
        }

        submitButton.setOnClickListener {
            val selectedAnswerIndex = radioGroup.indexOfChild(findViewById(radioGroup.checkedRadioButtonId))

            if (selectedAnswerIndex != -1) {
                val userAnswer = UserAnswer(question, selectedAnswerIndex)
                val intent = Intent(this, AnswerActivity::class.java)
                intent.putExtra("userAnswer", userAnswer)
                intent.putExtra("selectedTopic", selectedTopic)
                Log.d("wtf", "Current Question:$questionNumber")
                intent.putExtra("questionNumber", questionNumber + 1)
                intent.putExtra("totalQuestions",totalQuestions)
                startActivity(intent)
            } else {
                // Handle the case when no radio button is selected
            }
        }
    }
}