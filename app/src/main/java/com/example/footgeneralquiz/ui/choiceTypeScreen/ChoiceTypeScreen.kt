package com.example.footgeneralquiz.ui.choiceTypeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footgeneralquiz.theme.Green2
import com.example.footgeneralquiz.theme.Green3
import com.example.footgeneralquiz.util.supportWideScreen

@Composable
fun ChoiceTypeScreen(navController: NavController) {
    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    Surface(modifier = Modifier.supportWideScreen()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Green3, Green2),
                        start = Offset(0f, 0f), // top left corner
                        end = Offset(boxSize, boxSize) // bottom right corner
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ChoiceType()
        }
    }
}

@Composable
fun ChoiceType() {
}
