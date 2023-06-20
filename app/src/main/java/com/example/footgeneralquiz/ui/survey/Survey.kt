package com.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_TEST
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_TEST_2

@Composable
fun FirstQuestion(
    selectedAnswer: PossibleAnswer?,
    onOptionSelected: (PossibleAnswer) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceQuestion(
        title = QUESTION_TEST.titleQuestion.toString(),
        question = QUESTION_TEST,
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}

@Composable
fun SecondQuestion(
    selectedAnswer: PossibleAnswer?,
    onOptionSelected: (PossibleAnswer) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceQuestion(
        title = QUESTION_TEST_2.titleQuestion.toString(),
        question = QUESTION_TEST_2,
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}
