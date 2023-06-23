package com.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.util.QuestionDelivery.getTheRightQuestion
import com.example.footgeneralquiz.util.choiceSelected
import com.example.footgeneralquiz.util.levelSelected

@Composable
fun OneChoiceQuestion(
    selectedAnswer: PossibleAnswer?,
    withImage: Boolean,
    onOptionSelected: (PossibleAnswer) -> Unit,
    modifier: Modifier = Modifier,
    indexQuestion: String
) {
    val question = getTheRightQuestion(choiceSelected, levelSelected, indexQuestion)
    SingleChoiceQuestion(
        title = question.titleQuestion.toString(),
        question = question,
        withImage = withImage,
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}
