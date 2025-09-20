package tahadeta.example.footgeneralquiz.ui.survey

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.compose.BackHandler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import tahadeta.example.footgeneralquiz.data.UserAnswer
import tahadeta.example.footgeneralquiz.navigation.Screen
import tahadeta.example.footgeneralquiz.ui.survey.surveyScreen.SurveyQuestionsScreen
import tahadeta.example.footgeneralquiz.util.QuestionDelivery
import tahadeta.example.footgeneralquiz.util.userAnswer
import com.google.android.material.datepicker.MaterialDatePicker

private const val CONTENT_ANIMATION_DURATION = 300

/**
 * Displays a [SurveyQuestionsScreen] tied to the passed [SurveyViewModel]
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SurveyRoute(
    navController: NavController,
    onNavUp: () -> Unit
) {
    val viewModel: SurveyViewModel = viewModel()

    val surveyScreenData = viewModel.surveyScreenData ?: return

    BackHandler {
        if (!viewModel.onBackPressed()) {
            onNavUp()
        }
    }

    SurveyQuestionsScreen(
        surveyScreenData = surveyScreenData,
        isNextEnabled = viewModel.isNextEnabled,
        onClosePressed = {
            onNavUp()
        },
        onPreviousPressed = { viewModel.onPreviousPressed() },
        onNextPressed = { viewModel.onNextPressed() },
        onDonePressed = {
            navController.navigate(
                Screen.ResultScreen.withArgs(
                    QuestionDelivery.getTheResult(
                        userAnswer
                    ).toString()
                )
            )
            // re-init userAnswer of the actual session
            userAnswer = listOf(
                UserAnswer(0),
                UserAnswer(1),
                UserAnswer(2),
                UserAnswer(3),
                UserAnswer(4)
            )
        }
    ) { paddingValues ->

        val modifier = Modifier.padding(paddingValues)

        AnimatedContent(
            targetState = surveyScreenData
        ) { targetState ->

            when (targetState.surveyQuestion) {
                SurveyQuestion.FIRST -> OneChoiceQuestion(
                    selectedAnswer = viewModel.firstResponse,
                    withImage = viewModel.isQuestionWithImage,
                    onOptionSelected = viewModel::onFirstResponse,
                    modifier = modifier,
                    "0"
                )

                SurveyQuestion.SECOND -> OneChoiceQuestion(
                    selectedAnswer = viewModel.secondResponse,
                    withImage = viewModel.isQuestionWithImage,
                    onOptionSelected = viewModel::onSecondResponse,
                    modifier = modifier,
                    "1"
                )

                SurveyQuestion.THIRD -> OneChoiceQuestion(
                    selectedAnswer = viewModel.thirdResponse,
                    withImage = viewModel.isQuestionWithImage,
                    onOptionSelected = viewModel::onThirdResponse,
                    modifier = modifier,
                    "2"
                )

                SurveyQuestion.FOURTH -> OneChoiceQuestion(
                    selectedAnswer = viewModel.fourthResponse,
                    withImage = viewModel.isQuestionWithImage,
                    onOptionSelected = viewModel::onFourthResponse,
                    modifier = modifier,
                    "3"
                )

                SurveyQuestion.FIFTH ->
                    OneChoiceQuestion(
                        selectedAnswer = viewModel.fifthResponse,
                        withImage = viewModel.isQuestionWithImage,
                        onOptionSelected = viewModel::onFifthResponse,
                        modifier = modifier,
                        "4"
                    )
                else -> {
                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
private fun getTransition(
    initialIndex: Int,
    targetIndex: Int
): EnterTransition {
    return if (targetIndex > initialIndex) {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth }, // slide in from right
            animationSpec = tween(300)
        )
    } else {
        slideInHorizontally(
            initialOffsetX = { fullWidth -> -fullWidth }, // slide in from left
            animationSpec = tween(300)
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun getExitTransition(
    initialIndex: Int,
    targetIndex: Int
): ExitTransition {
    return if (targetIndex > initialIndex) {
        slideOutHorizontally(
            targetOffsetX = { fullWidth -> -fullWidth }, // slide out to left
            animationSpec = tween(300)
        )
    } else {
        slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth }, // slide out to right
            animationSpec = tween(300)
        )
    }
}

private fun showTakeawayDatePicker(
    date: Long?,
    supportFragmentManager: FragmentManager,
    onDateSelected: (date: Long) -> Unit
) {
    val picker = MaterialDatePicker.Builder.datePicker()
        .setSelection(date)
        .build()
    picker.show(supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        picker.selection?.let {
            onDateSelected(it)
        }
    }
}

private tailrec fun Context.findActivity(): AppCompatActivity =
    when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> this.baseContext.findActivity()
        else -> throw IllegalArgumentException("Could not find activity!")
    }
