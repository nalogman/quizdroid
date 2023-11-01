package edu.uw.ischool.nalogman.quizdroid

import java.io.Serializable

// Question data model class
data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
) : Serializable
