package edu.uw.ischool.nalogman.quizdroid

interface TopicRepository {
    fun getAllTopics(): List<Topic>
    fun getTopicById(topicId: Int): Topic?
}