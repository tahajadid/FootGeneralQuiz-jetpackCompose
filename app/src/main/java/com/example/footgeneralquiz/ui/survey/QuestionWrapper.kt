package com.example.footgeneralquiz.ui.survey

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.theme.Blue3
import com.example.footgeneralquiz.theme.FtyFontFamily
import com.example.footgeneralquiz.theme.Green2

@Composable
fun QuestionWrapper(
    title: String,
    modifier: Modifier = Modifier,
    withImage: Boolean,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))
        QuestionTitle(title)
        Spacer(Modifier.height(18.dp))
        if (withImage) {
            Image(
                painter = painterResource(id = R.drawable.logo_splash),
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
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
        fontFamily = FtyFontFamily,
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
