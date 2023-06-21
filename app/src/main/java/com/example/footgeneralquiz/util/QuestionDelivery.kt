package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.Question
import com.example.footgeneralquiz.data.UserAnswer
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_BUNDLE_0_0
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_BUNDLE_0_1
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_BUNDLE_0_2
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_BUNDLE_1_0
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_BUNDLE_1_1
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_BUNDLE_1_2

object QuestionDelivery {

    fun getTheRightQuestion(idChoice: String, idLevel: String, indexQuestion: String): Question {
        when (idLevel) {
            "0" -> {
                if (idChoice == "0") return QUESTION_BUNDLE_0_0[indexQuestion.toInt()]
                else if (idChoice == "1") return QUESTION_BUNDLE_1_0[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_0[indexQuestion.toInt()]
            }
            "1" -> {
                if (idChoice == "0") return QUESTION_BUNDLE_0_1[indexQuestion.toInt()]
                else if (idChoice == "1") return QUESTION_BUNDLE_1_1[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_1[indexQuestion.toInt()]
            }
            else -> {
                if (idChoice == "0") return QUESTION_BUNDLE_0_2[indexQuestion.toInt()]
                else if (idChoice == "1") return QUESTION_BUNDLE_1_2[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_2[indexQuestion.toInt()]
            }
        }
    }

    fun getTheResult(userAnswer: List<UserAnswer>): Int {
        var score = 0
        userAnswer.forEach {
            if(it.selectedAnswer!!.equals(it.correctAnswer)) score ++
        }
        return score
    }
}
