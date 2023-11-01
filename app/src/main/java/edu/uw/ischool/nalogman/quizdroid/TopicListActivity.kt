package edu.uw.ischool.nalogman.quizdroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TopicListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_list)

        val recyclerView: RecyclerView = findViewById(R.id.topicRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create sample questions for Math
        val mathQuestions = listOf(
            Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
            Question("What is the square root of 25?", listOf("3", "4", "5", "6"), 2),
            Question("What is 10 * 5?", listOf("40", "50", "60", "70"), 1),
            Question("What is 3 squared?", listOf("6", "9", "12", "15"), 1),
            Question("What is the sum of angles in a triangle?", listOf("90 degrees", "120 degrees", "180 degrees", "360 degrees"), 2)
        )

        // Create sample questions for Physics
        val physicsQuestions = listOf(
            Question("What is Newton's first law of motion?", listOf("Inertia", "Force", "Action", "Reaction"), 0),
            Question("What is the speed of light?", listOf("299,792 km/s", "150,000 km/s", "200,000 km/s", "100,000 km/s"), 0),
            Question("What is the formula for kinetic energy?", listOf("mgh", "mv^2", "1/2 * mv^2", "mgh/2"), 2),
            Question("What is the SI unit of force?", listOf("Newton", "Joule", "Watt", "Ampere"), 0),
            Question("What is the acceleration due to gravity on Earth?", listOf("5 m/s^2", "9.8 m/s^2", "15 m/s^2", "20 m/s^2"), 1)
        )

        // Create sample questions for Marvel Super Heroes
        val marvelQuestions = listOf(
            Question("Who is Iron Man's alter ego?", listOf("Bruce Wayne", "Tony Stark", "Steve Rogers", "Clark Kent"), 1),
            Question("What is Thor's hammer called?", listOf("Mjolnir", "Excalibur", "Stormbreaker", "Gungnir"), 0),
            Question("Which superhero is known for the catchphrase 'I am Groot'?", listOf("Spider-Man", "Hulk", "Groot", "Captain America"), 2),
            Question("Who is the arch-nemesis of Spider-Man?", listOf("Green Goblin", "Venom", "Doctor Octopus", "Kingpin"), 0),
            Question("In which movie did Black Widow first appear in the Marvel Cinematic Universe?", listOf("Iron Man", "The Avengers", "Thor", "Captain America: The Winter Soldier"), 0)
        )

        // Create sample topics
        val topics = listOf(
            Topic("Math", "Test your math skills",5, mathQuestions),
            Topic("Physics", "Explore the world of physics",5, physicsQuestions),
            Topic("Marvel Super Heroes", "Discover the Marvel universe",5, marvelQuestions)
        )

        // Set up the RecyclerView with the TopicListAdapter
        recyclerView.adapter = TopicListAdapter(topics) { selectedTopic ->
            // Handle the click event
            val intent = Intent(this, TopicOverviewActivity::class.java)
            intent.putExtra("selectedTopic", selectedTopic)
            intent.putExtra("totalQuestions", selectedTopic.totalQuestions)
            startActivity(intent)
        }
    }
}