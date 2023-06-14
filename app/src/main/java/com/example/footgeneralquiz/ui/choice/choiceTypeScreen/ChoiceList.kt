package com.example.footgeneralquiz.ui.choice.choiceTypeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footgeneralquiz.R
import com.example.footgeneralquiz.theme.Green1
import com.example.footgeneralquiz.util.Constants.LIST_OF_CHOICES

@Composable
fun ChoiceList(selectedItem: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        // content padding
        contentPadding = PaddingValues(
            start = 6.dp,
            top = 6.dp,
            end = 12.dp,
            bottom = 6.dp
        ),
        content = {
            items(LIST_OF_CHOICES.size) { index ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .clickable { selectedItem(index + 1) },

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
                            painter = painterResource(id = getImageType(LIST_OF_CHOICES[index].icon)),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.height(120.dp)
                        )

                        Text(
                            text = LIST_OF_CHOICES[index].title.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
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

/**
 * function to get the right image from assets
 */
fun getImageType(id: String?): Int {
    when (id) {
        "WORLD_CUP" -> return R.drawable.worldcup
        "TEAMS" -> return R.drawable.worldcup
        "LEAGUE_EU" -> return R.drawable.worldcup
        "LEAGUE_AF" -> return R.drawable.worldcup
        "PLAYERS" -> return R.drawable.worldcup
        "FLAGS" -> return R.drawable.worldcup
        "AWARDS" -> return R.drawable.worldcup
        "VARIOUS" -> return R.drawable.worldcup
        else -> return R.drawable.worldcup
    }
}
