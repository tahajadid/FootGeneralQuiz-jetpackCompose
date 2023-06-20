package com.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.util.QuestionDelivery.getTheRightQuestion

@Composable
fun FirstQuestion(
    selectedAnswer: PossibleAnswer?,
    onOptionSelected: (PossibleAnswer) -> Unit,
    modifier: Modifier = Modifier
) {
    val question = getTheRightQuestion("0", "0", "0")
    SingleChoiceQuestion(
        title = question.titleQuestion.toString(),
        question = question,
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
    val question = getTheRightQuestion("0", "0", "1")
    SingleChoiceQuestion(
        title = question.titleQuestion.toString(),
        question = question,
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}
