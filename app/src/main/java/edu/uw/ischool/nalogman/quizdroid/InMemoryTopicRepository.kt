package edu.uw.ischool.nalogman.quizdroid

class InMemoryTopicRepository : TopicRepository {
    private val mathQuestions = listOf(
        Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
        Question("What is the square root of 25?", listOf("3", "4", "5", "6"), 2),
        Question("What is 10 * 5?", listOf("40", "50", "60", "70"), 1),
        Question("What is 3 squared?", listOf("6", "9", "12", "15"), 1),
        Question("What is the sum of angles in a triangle?", listOf("90 degrees", "120 degrees", "180 degrees", "360 degrees"), 2)
    )

    // Create sample questions for Physics
    private val physicsQuestions = listOf(
        Question("What is Newton's first law of motion?", listOf("Inertia", "Force", "Action", "Reaction"), 0),
        Question("What is the speed of light?", listOf("299,792 km/s", "150,000 km/s", "200,000 km/s", "100,000 km/s"), 0),
        Question("What is the formula for kinetic energy?", listOf("mgh", "mv^2", "1/2 * mv^2", "mgh/2"), 2),
        Question("What is the SI unit of force?", listOf("Newton", "Joule", "Watt", "Ampere"), 0),
        Question("What is the acceleration due to gravity on Earth?", listOf("5 m/s^2", "9.8 m/s^2", "15 m/s^2", "20 m/s^2"), 1)
    )

    // Create sample questions for Marvel Super Heroes
    private val marvelQuestions = listOf(
        Question("Who is Iron Man's alter ego?", listOf("Bruce Wayne", "Tony Stark", "Steve Rogers", "Clark Kent"), 1),
        Question("What is Thor's hammer called?", listOf("Mjolnir", "Excalibur", "Storm-breaker", "Gungnir"), 0),
        Question("Which superhero is known for the catchphrase 'I am Groot'?", listOf("Spider-Man", "Hulk", "Groot", "Captain America"), 2),
        Question("Who is the arch-nemesis of Spider-Man?", listOf("Green Goblin", "Venom", "Doctor Octopus", "Kingpin"), 0),
        Question("In which movie did Black Widow first appear in the Marvel Cinematic Universe?", listOf("Iron Man", "The Avengers", "Thor", "Captain America: The Winter Soldier"), 0)
    )

    private val topics: List<Topic> = listOf(
        Topic(
            1, // Unique ID for Math
            "Math",
            "Test your math skills",
            "Are you ready to crunch some numbers and solve mathematical puzzles? Dive into the world of mathematics with our challenging quiz. Sharpen your mind and enhance your problem-solving skills.",
            mathQuestions
        ),
        Topic(
            2, // Unique ID for Physics
            "Physics",
            "Explore the world of physics",
            "Embark on a journey through the fascinating realm of physics. From Newton's laws to the mysteries of light and energy, challenge yourself with questions that unravel the secrets of the universe.",
            physicsQuestions
        ),
        Topic(
            3, // Unique ID for Marvel Super Heroes
            "Marvel Super Heroes",
            "Discover the Marvel universe",
            "Join the epic adventure of Marvel Super Heroes. Test your knowledge of iconic characters, epic battles, and heroic deeds. Unleash your inner superhero and prove that you're a true Marvel fan.",
            marvelQuestions
        )
    )// Initialize your list of topics here

    override fun getAllTopics(): List<Topic> = topics

    override fun getTopicById(topicId: Int): Topic? =
        topics.find { it.hashCode() == topicId }
}