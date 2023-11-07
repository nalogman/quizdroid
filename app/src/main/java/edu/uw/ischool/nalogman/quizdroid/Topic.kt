package edu.uw.ischool.nalogman.quizdroid

import java.io.Serializable

// Topic data model class
data class Topic(
    val id: Int,
    val name: String,
    val description: String,
    val longDescription: String,
    val questions: List<Question>
) : Serializable

