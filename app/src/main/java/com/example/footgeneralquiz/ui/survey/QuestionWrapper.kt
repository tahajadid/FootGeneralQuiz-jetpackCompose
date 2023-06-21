package com.example.footgeneralquiz.ui.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footgeneralquiz.theme.Blue3
import com.example.footgeneralquiz.theme.Green2
import com.example.footgeneralquiz.theme.stronglyDeemphasizedAlpha

@Composable
fun QuestionWrapper(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))
        QuestionTitle(title)
        Spacer(Modifier.height(18.dp))
        content()
    }
}

@Composable
private fun QuestionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = Green2,
        modifier = modifier
            .fillMaxWidth()
            .background(
                Blue3,
                shape = MaterialTheme.shapes.small
            )
            .padding(vertical = 24.dp, horizontal = 16.dp)
    )
}

/*
@Composable
private fun QuestionDirections(
    directionsLabel: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = directionsLabel,
        color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = stronglyDeemphasizedAlpha),
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    )
}
 */