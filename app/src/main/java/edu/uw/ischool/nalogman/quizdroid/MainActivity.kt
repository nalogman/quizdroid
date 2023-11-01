package edu.uw.ischool.nalogman.quizdroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Assuming you want to start with the TopicListActivity as the main screen
        val intent = Intent(this, TopicListActivity::class.java)
        startActivity(intent)

        // Finish the MainActivity so that pressing the back button doesn't go back here
        finish()
    }
}