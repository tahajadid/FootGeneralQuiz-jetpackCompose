package com.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.footgeneralquiz.data.PossibleAnswer
import com.example.footgeneralquiz.data.Question
import com.example.footgeneralquiz.util.typeSelected
import com.example.footgeneralquiz.util.userAnswer

class SurveyViewModel() : ViewModel() {

    private val questionOrder: List<SurveyQuestion> = listOf(
        SurveyQuestion.FIRST,
        SurveyQuestion.SECOND,
        SurveyQuestion.THIRD,
        SurveyQuestion.FOURTH,
        SurveyQuestion.FIFTH
    )

    private var questionIndex = 0

    // ----- Responses exposed as State -----
    private val _firstResponse = mutableStateOf<PossibleAnswer?>(null)
    val firstResponse: PossibleAnswer?
        get() = _firstResponse.value

    private val _secondResponse = mutableStateOf<PossibleAnswer?>(null)
    val secondResponse: PossibleAnswer?
        get() = _secondResponse.value

    private val _thirdResponse = mutableStateOf<PossibleAnswer?>(null)
    val thirdResponse: PossibleAnswer?
        get() = _thirdResponse.value

    private val _fourthResponse = mutableStateOf<PossibleAnswer?>(null)
    val fourthResponse: PossibleAnswer?
        get() = _fourthResponse.value

    private val _fifthResponse = mutableStateOf<PossibleAnswer?>(null)
    val fifthResponse: PossibleAnswer?
        get() = _fifthResponse.value

    // ----- Survey status exposed as State -----
    private val _surveyScreenData = mutableStateOf(createSurveyScreenData())
    val surveyScreenData: SurveyScreenData?
        get() = _surveyScreenData.value

    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    val isQuestionWithImage: Boolean get() = typeSelected.equals("2") || typeSelected.equals("5")

    /**
     * Returns true if the ViewModel handled the back press (i.e., it went back one question)
     */
    fun onBackPressed(): Boolean {
        if (questionIndex == 0) {
            return false
        }
        changeQuestion(questionIndex - 1)
        return true
    }

    fun onPreviousPressed() {
        if (questionIndex == 0) {
            throw IllegalStateException("onPreviousPressed when on question 0")
        }
        changeQuestion(questionIndex - 1)
    }

    fun onNextPressed() {
        changeQuestion(questionIndex + 1)
    }

    private fun changeQuestion(newQuestionIndex: Int) {
        questionIndex = newQuestionIndex
        _isNextEnabled.value = getIsNextEnabled()
        _surveyScreenData.value = createSurveyScreenData()
    }

    fun onFirstResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _firstResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onSecondResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _secondResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onThirdResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _thirdResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onFourthResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _fourthResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onFifthResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _fifthResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun changeUserResponse(idPossibleAnswer: String, idCorrectAnswer: String) {
        userAnswer[surveyScreenData!!.questionIndex].selectedAnswer = idPossibleAnswer
        userAnswer[surveyScreenData!!.questionIndex].correctAnswer = idCorrectAnswer
    }

    private fun getIsNextEnabled(): Boolean {
        return when (questionOrder[questionIndex]) {
            SurveyQuestion.FIRST -> _firstResponse.value != null
            SurveyQuestion.SECOND -> _secondResponse.value != null
            SurveyQuestion.THIRD -> _thirdResponse.value != null
            SurveyQuestion.FOURTH -> _fourthResponse.value != null
            SurveyQuestion.FIFTH -> _fifthResponse.value != null
        }
    }

    private fun createSurveyScreenData(): SurveyScreenData {
        return SurveyScreenData(
            questionIndex = questionIndex,
            questionCount = questionOrder.size,
            shouldShowPreviousButton = questionIndex > 0,
            shouldShowDoneButton = questionIndex == questionOrder.size - 1,
            surveyQuestion = questionOrder[questionIndex]
        )
    }
}

enum class SurveyQuestion {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
}

data class SurveyScreenData(
    val questionIndex: Int,
    val questionCount: Int,
    val shouldShowPreviousButton: Boolean,
    val shouldShowDoneButton: Boolean,
    val surveyQuestion: SurveyQuestion
)
