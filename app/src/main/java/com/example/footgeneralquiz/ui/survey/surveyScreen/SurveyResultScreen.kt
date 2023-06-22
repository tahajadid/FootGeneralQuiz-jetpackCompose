package com.example.footgeneralquiz.ui.survey.surveyScreen

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.theme.Blue3
import com.example.footgeneralquiz.theme.FootGeneralQuizTheme
import com.example.footgeneralquiz.theme.FtyFontFamily
import com.example.footgeneralquiz.theme.Gold2
import com.example.footgeneralquiz.theme.Green2
import com.example.footgeneralquiz.theme.Green3
import com.example.footgeneralquiz.util.supportWideScreen
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
// Scaffold is experimental in m3
@Composable
fun SurveyResultScreen(
    onDonePressed: () -> Unit,
    result: String
) {
    Surface(modifier = Modifier.supportWideScreen()) {
        Scaffold(
            content = {
                SurveyResult(
                    title = "Result",
                    result = result
                )
            },
            bottomBar = {
                OutlinedButton(
                    onClick = onDonePressed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 30.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.done),
                        color = Blue3,
                        fontFamily = FtyFontFamily
                    )
                }
            }
        )
    }
}

@Composable
private fun SurveyResult(
    title: String,
    result: String
) {
    val constraints = ConstraintSet {
        val title = createRefFor("title")
        val progressHover = createRefFor("progressHover")
        val progress = createRefFor("progress")
        val result = createRefFor("result")

        constrain(title) {
            bottom.linkTo(progressHover.top, margin = 40.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(progressHover) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(progress) {
            top.linkTo(progressHover.top)
            bottom.linkTo(progressHover.bottom)
            start.linkTo(progressHover.start)
            end.linkTo(progressHover.end)
        }

        constrain(result) {
            top.linkTo(progressHover.top)
            bottom.linkTo(progressHover.bottom)
            start.linkTo(progressHover.start)
            end.linkTo(progressHover.end)
            // height = Dimension.value(200.dp)
        }
    }

    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    ConstraintLayout(
        constraints,
        modifier =
        Modifier.fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Green3, Green2),
                    start = Offset(0f, 0f), // top left corner
                    end = Offset(boxSize, boxSize) // bottom right corner
                )
            )
    ) {
        var progress by remember { mutableStateOf(0f) }

        val animatedProgress = animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        ).value

        Text(
            text = "Result",
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            color = Gold2,
            fontFamily = FtyFontFamily,
            modifier = Modifier
                .layoutId("title")
        )

        Text(
            text = result,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 26.sp,
            color = Blue3,
            fontWeight = FontWeight.Bold,
            fontFamily = FtyFontFamily,
            modifier = Modifier.padding(horizontal = 20.dp)
                .layoutId("result")
        )

        CircularProgressIndicator(
            progress = 1f,
            strokeWidth = 14.dp,
            color = Blue3,
            modifier = Modifier.height(140.dp).width(140.dp)
                .layoutId("progressHover")
        )

        CircularProgressIndicator(
            progress = animatedProgress,
            strokeWidth = 14.dp,
            color = Blue3,
            modifier = Modifier.height(140.dp).width(140.dp)
                .layoutId("progress")
        )

        var stateOfLoop by remember { mutableStateOf(true) }

        // Just once
        LaunchedEffect(Unit) {
            while (stateOfLoop) {
                if (progress < 1f) progress += 0.2f
                else stateOfLoop = false
                delay(200)
            }
        }
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    FootGeneralQuizTheme {
        SurveyResultScreen({}, "1 / 5")
    }
}
