package com.example.footgeneralquiz.ui.choice

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.theme.ChallengeFontFamily
import com.example.footgeneralquiz.theme.FootGeneralQuizTheme
import com.example.footgeneralquiz.theme.Gold

@Composable
fun ChoiceHeader(
    title: String,
    level: String
) {
    // Background imageBox
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = level,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = ChallengeFontFamily,
            color = Gold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .weight(0.2f)

        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = ChallengeFontFamily,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
                .weight(0.6f)

        )

        Image(
            painter = painterResource(id = R.drawable.info),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(36.dp)
                .width(36.dp)
                .weight(0.2f)
                .padding(6.dp)
        )
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeSceePreview() {
    FootGeneralQuizTheme {
        ChoiceHeader("Welcome", "1/2")
    }
}
