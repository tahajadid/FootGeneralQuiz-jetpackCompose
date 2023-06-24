package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.data.Question
import com.example.footgeneralquiz.data.UserAnswer
import com.example.footgeneralquiz.util.question.FlagQuestions.QUESTION_BUNDLE_5_0
import com.example.footgeneralquiz.util.question.FlagQuestions.QUESTION_BUNDLE_5_1
import com.example.footgeneralquiz.util.question.ListOfQuestions.QUESTION_BUNDLE_0_0
import com.example.footgeneralquiz.util.question.ListOfQuestions.QUESTION_BUNDLE_0_1
import com.example.footgeneralquiz.util.question.ListOfQuestions.QUESTION_BUNDLE_0_2
import com.example.footgeneralquiz.util.question.ListOfQuestions.QUESTION_BUNDLE_1_0
import com.example.footgeneralquiz.util.question.ListOfQuestions.QUESTION_BUNDLE_1_1
import com.example.footgeneralquiz.util.question.ListOfQuestions.QUESTION_BUNDLE_1_2
import com.example.footgeneralquiz.util.question.PlayerQuestions.QUESTION_BUNDLE_2_0
import com.example.footgeneralquiz.util.question.PlayerQuestions.QUESTION_BUNDLE_2_1

object QuestionDelivery {

    fun getTheRightQuestion(idType: String, idLevel: String, indexQuestion: String): Question {
        when (idLevel) {
            "0" -> {
                if (idType == "0") return QUESTION_BUNDLE_0_0[indexQuestion.toInt()]
                else if (idType == "1") return QUESTION_BUNDLE_1_0[indexQuestion.toInt()]
                else if (idType == "2") return QUESTION_BUNDLE_2_0[indexQuestion.toInt()]
                else if (idType == "5") return QUESTION_BUNDLE_5_0[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_0[indexQuestion.toInt()]
            }
            "1" -> {
                if (idType == "0") return QUESTION_BUNDLE_0_1[indexQuestion.toInt()]
                else if (idType == "1") return QUESTION_BUNDLE_1_1[indexQuestion.toInt()]
                else if (idType == "2") return QUESTION_BUNDLE_2_1[indexQuestion.toInt()]
                else if (idType == "5") return QUESTION_BUNDLE_5_1[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_1[indexQuestion.toInt()]
            }
            else -> {
                if (idType == "0") return QUESTION_BUNDLE_0_2[indexQuestion.toInt()]
                else if (idType == "1") return QUESTION_BUNDLE_1_2[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_2[indexQuestion.toInt()]
            }
        }
    }

    fun getTheResult(userAnswer: List<UserAnswer>): Int {
        var score = 0
        userAnswer.forEach {
            if (it.selectedAnswer!!.equals(it.correctAnswer)) score++
        }
        return score
    }

    fun getTheRightImage(index: Int): Int {
        when (index) {
            5 -> return R.drawable.question1
            6 -> return R.drawable.question2
            7 -> return R.drawable.question3
            8 -> return R.drawable.question4
            9 -> return R.drawable.question5
            10 -> return R.drawable.question6
            11 -> return R.drawable.question7
            12 -> return R.drawable.question8
            13 -> return R.drawable.question9
            14 -> return R.drawable.question10
            15 -> return R.drawable.flag1
            16 -> return R.drawable.flag2
            17 -> return R.drawable.flag3
            18 -> return R.drawable.flag4
            19 -> return R.drawable.flag5
            20 -> return R.drawable.flag6
            21 -> return R.drawable.flag7
            22 -> return R.drawable.flag8
            23 -> return R.drawable.flag9
            else -> return R.drawable.flag10
        }
    }

    fun getTheRightFlag(index: Int): Int {
        when (index) {
            5 -> return R.drawable.question1
            6 -> return R.drawable.question2
            7 -> return R.drawable.question3
            8 -> return R.drawable.question4
            9 -> return R.drawable.question5
            10 -> return R.drawable.question6
            11 -> return R.drawable.question7
            12 -> return R.drawable.question8
            13 -> return R.drawable.question9
            else -> return R.drawable.question6
        }
    }
}
