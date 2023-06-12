package com.example.footgeneralquiz.ui.choiceLevelScreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.data.Level
import com.example.footgeneralquiz.theme.ChallengeFontFamily
import com.example.footgeneralquiz.theme.FootGeneralQuizTheme
import com.example.footgeneralquiz.theme.Gold2
import com.example.footgeneralquiz.theme.Green1
import com.example.footgeneralquiz.theme.Green2
import com.example.footgeneralquiz.util.Constants.LIST_OF_LEVELS

@Composable
fun LevelList(
    onItemSelected: (Level) -> Unit,
    selectedLevel: Level?
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))

        LIST_OF_LEVELS.forEach { it ->
            val selected = it == selectedLevel
            LevelItemView(
                onItemSelected = { onItemSelected(it) },
                selectedAnswer = selected,
                index = it.idLevel!!.toInt()
            )
        }

        Spacer(Modifier.height(18.dp))
    }
}

@Composable
fun LevelItemView(
    onItemSelected: () -> Unit,
    selectedAnswer: Boolean,
    index: Int
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .selectable(
                selectedAnswer,
                onClick = onItemSelected,
                role = Role.RadioButton
            ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor =
            if (selectedAnswer) {
                Green1
            } else {
                Green2
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = getImageLevel(index)),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(120.dp)
            )

            Text(
                text = LIST_OF_LEVELS[index].title.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Gold2,
                fontFamily = ChallengeFontFamily,
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * function to get the right image from assets
 */
fun getImageLevel(id: Int): Int {
    when (id) {
        0 -> return R.drawable.level1
        1 -> return R.drawable.level2
        else -> return R.drawable.level3
    }
}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPrevew() {
    FootGeneralQuizTheme {
        LevelList(
            onItemSelected = {},
            selectedLevel = Level(1, "Level 2")
        )
    }
}
