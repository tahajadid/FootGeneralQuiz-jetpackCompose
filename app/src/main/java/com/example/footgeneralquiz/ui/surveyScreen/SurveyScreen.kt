package com.example.footgeneralquiz.ui.surveyScreen

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.footgeneralquiz.util.supportWideScreen

@Composable
fun SurveyScreen(navController: NavController) {
    Surface(modifier = Modifier.supportWideScreen()) {
        // ChoiceType(navController)
    }
}
