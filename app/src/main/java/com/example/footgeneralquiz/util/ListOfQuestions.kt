package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.data.Question

object ListOfQuestions {

    var POSSIBLE_ANSWERS_1 = listOf(
        PossibleAnswer(0, "Level 1"),
        PossibleAnswer(1, "Level 2"),
        PossibleAnswer(2, "-Right-"),
        PossibleAnswer(3, "Level 4")
    )

    var QUESTION_1 = Question(
        0,
        "Test Question 1?",
        2,
        POSSIBLE_ANSWERS_1
    )

    var POSSIBLE_ANSWERS_2 = listOf(
        PossibleAnswer(0, "Answ 1"),
        PossibleAnswer(1, "-Right-"),
        PossibleAnswer(2, "Answ 3"),
        PossibleAnswer(3, "Answ 4")
    )

    var QUESTION_2 = Question(
        1,
        "Question 2 ?",
        1,
        POSSIBLE_ANSWERS_2
    )

    var POSSIBLE_ANSWERS_3 = listOf(
        PossibleAnswer(0, "Q3 Answ 1"),
        PossibleAnswer(1, "Q3  Answ 2"),
        PossibleAnswer(2, "AnQ3  sw 3"),
        PossibleAnswer(3, "-Right-")
    )

    var QUESTION_3 = Question(
        2,
        "Question 3 ?",
        3,
        POSSIBLE_ANSWERS_3
    )

    var POSSIBLE_ANSWERS_4 = listOf(
        PossibleAnswer(0, "-Right-"),
        PossibleAnswer(1, "POSSIBLE_ANSWERS_4 2"),
        PossibleAnswer(2, "POSSIBLE_ANSWERS_4 3"),
        PossibleAnswer(3, "POSSIBLE_ANSWERS_4 4")
    )

    var QUESTION_4 = Question(
        3,
        "Test Question 4 ?",
        0,
        POSSIBLE_ANSWERS_4
    )

    var POSSIBLE_ANSWERS_5 = listOf(
        PossibleAnswer(0, "Answ -- 5"),
        PossibleAnswer(1, "Answ -- 5"),
        PossibleAnswer(2, "Answ -- 5"),
        PossibleAnswer(3, "-Right-")
    )

    var QUESTION_5 = Question(
        4,
        "Question 5 -- ?",
        3,
        POSSIBLE_ANSWERS_5
    )

    /**
     * The bundles
     */
    var QUESTION_BUNDLE_0_0 = listOf(
        QUESTION_1,
        QUESTION_2,
        QUESTION_3,
        QUESTION_4,
        QUESTION_5
    )

    var QUESTION_BUNDLE_0_1 = listOf(
        QUESTION_1,
        QUESTION_2,
        QUESTION_3,
        QUESTION_4,
        QUESTION_5
    )
    var QUESTION_BUNDLE_0_2 = listOf(
        QUESTION_1,
        QUESTION_2,
        QUESTION_3,
        QUESTION_4,
        QUESTION_5
    )

    var QUESTION_BUNDLE_1_0 = listOf(
        QUESTION_1,
        QUESTION_2,
        QUESTION_3,
        QUESTION_4,
        QUESTION_5
    )

    var QUESTION_BUNDLE_1_1 = listOf(
        QUESTION_1,
        QUESTION_2,
        QUESTION_3,
        QUESTION_4,
        QUESTION_5
    )
    var QUESTION_BUNDLE_1_2 = listOf(
        QUESTION_1,
        QUESTION_2,
        QUESTION_3,
        QUESTION_4,
        QUESTION_5
    )
}
