package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.UserAnswer

// Choice selected by the user
internal var choiceSelected = ""

// Level selected by the user
internal var levelSelected = ""

// User Answer to calculate the score
internal var userAnswer = listOf(
    UserAnswer(0),
    UserAnswer(1),
    UserAnswer(2),
    UserAnswer(3),
    UserAnswer(4)
)

// Index Question
internal var indexQuestion = 0