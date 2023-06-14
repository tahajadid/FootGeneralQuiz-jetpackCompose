package com.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.util.ListOfQuestions.QUESTION_TEST

@Composable
fun FirstQuestion(
    selectedAnswer: PossibleAnswer?,
    onOptionSelected: (PossibleAnswer) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceQuestion(
        title = QUESTION_TEST.titleQuestion.toString(),
        directionsLabel = "Next",
        question = QUESTION_TEST,
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}
