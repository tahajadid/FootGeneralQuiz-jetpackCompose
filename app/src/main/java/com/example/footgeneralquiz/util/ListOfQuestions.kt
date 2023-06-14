package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.data.Question

object ListOfQuestions {

    var POSSIBLE_ANSWERS = listOf(
        PossibleAnswer(0, "Level 1"),
        PossibleAnswer(1, "Level 2"),
        PossibleAnswer(2, "Level 3")
    )

    var QUESTION_TEST = Question(
        0,
        "Test Question ?",
        2,
        POSSIBLE_ANSWERS
    )
}
