package edu.uw.ischool.nalogman.quizdroid

import java.io.Serializable

data class UserAnswer(val question: Question, val selectedAnswerIndex: Int) : Serializable