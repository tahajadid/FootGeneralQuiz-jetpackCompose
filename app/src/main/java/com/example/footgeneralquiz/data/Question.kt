package com.example.footgeneralquiz.data

data class Question(
    var idQuestion: Int? = null,
    var titleQuestion: String? = null,
    var idCorrectAnswer: Int? = null,
    var possibleAnswers: List<PossibleAnswer> = listOf()
)
