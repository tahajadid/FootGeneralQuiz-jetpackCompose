package com.example.footgeneralquiz.ui.splashScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.theme.FootGeneralQuizTheme
import com.example.footgeneralquiz.util.supportWideScreen

@Composable
fun SplashScreen(navController: NavController) {
    // A surface container using the 'background' color from the theme
    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    Surface(modifier = Modifier.supportWideScreen()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Green, Color.Yellow),
                        start = Offset(0f, 0f), // top left corner
                        end = Offset(boxSize, boxSize) // bottom right corner
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Splash()
        }
    }
}

@Composable
fun Splash() {
    Logo(
        modifier = Modifier
            .padding(horizontal = 76.dp)
    )
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        modifier = modifier,
        contentDescription = null
    )
}

fun linearGradient(
    vararg colorStops: Pair<Float, Color>,
    start: Offset = Offset.Zero,
    end: Offset = Offset.Infinite,
    tileMode: TileMode = TileMode.Clamp
) {
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreview() {
    FootGeneralQuizTheme {
        Splash()
    }
}
