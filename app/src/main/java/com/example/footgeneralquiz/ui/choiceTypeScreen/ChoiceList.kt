package com.example.footgeneralquiz.ui.choiceTypeScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.footgeneralquiz.theme.FootGeneralQuizTheme
import com.example.footgeneralquiz.theme.Green1

@Composable
fun ChoiceList(messages: List<String>) {
    Column {
        messages.forEach { message ->
            Text(text = message)
        }
    }
}

@Composable
fun LazyVerticalGridDemo() {
    val list = (1..20).map { it.toString() }

    LazyVerticalGrid(
        // columns = GridCells.Adaptive(128.dp),
        columns = GridCells.Fixed(2),

        // content padding
        contentPadding = PaddingValues(
            start = 6.dp,
            top = 6.dp,
            end = 12.dp,
            bottom = 6.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Green1
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.worldcup),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.height(120.dp)
                        )

                        Text(
                            text = list[index],
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun ChoiceItem() {
    Text(text = "message")
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeSceeePreview() {
    FootGeneralQuizTheme {
        LazyVerticalGridDemo()
    }
}
