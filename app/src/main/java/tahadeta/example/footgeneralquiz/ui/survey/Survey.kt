package tahadeta.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tahadeta.example.footgeneralquiz.data.PossibleAnswer
import tahadeta.example.footgeneralquiz.data.Question
import tahadeta.example.footgeneralquiz.util.QuestionDelivery.getTheRightQuestion
import tahadeta.example.footgeneralquiz.util.typeSelected
import tahadeta.example.footgeneralquiz.util.levelSelected

@Composable
fun OneChoiceQuestion(
    selectedAnswer: PossibleAnswer?,
    withImage: Boolean,
    onOptionSelected: (PossibleAnswer, Question) -> Unit,
    modifier: Modifier = Modifier,
    indexQuestion: String
) {
    val question = getTheRightQuestion(typeSelected, levelSelected, indexQuestion)
    SingleChoiceQuestion(
        title = question.titleQuestion.toString(),
        question = question,
        withImage = withImage,
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}
