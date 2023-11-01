package edu.uw.ischool.nalogman.quizdroid

import java.io.Serializable

// Topic data model class
data class Topic(
    val name: String,
    val description: String,
    val totalQuestions: Int, // This is the corrected property name
    val questions: List<Question>
) : Serializable

