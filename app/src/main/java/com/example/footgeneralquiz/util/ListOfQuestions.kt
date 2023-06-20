package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.data.Question

object ListOfQuestions {

    var POSSIBLE_ANSWERS = listOf(
        PossibleAnswer(0, "Level 1"),
        PossibleAnswer(1, "Level 2"),
        PossibleAnswer(2, "Level 3"),
        PossibleAnswer(3, "Level 4")
    )

    var QUESTION_TEST = Question(
        0,
        "Test Question ?",
        2,
        POSSIBLE_ANSWERS
    )

    var POSSIBLE_ANSWERS_2 = listOf(
        PossibleAnswer(0, "Answ 1"),
        PossibleAnswer(1, "Answ 2"),
        PossibleAnswer(2, "Answ 3"),
        PossibleAnswer(3, "Answ 4")
    )

    var QUESTION_TEST_2 = Question(
        0,
        "Question 2 ?",
        1,
        POSSIBLE_ANSWERS_2
    )
}
