package com.example.footgeneralquiz

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footgeneralquiz.navigation.Navigation
import com.example.footgeneralquiz.theme.FootGeneralQuizTheme

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var activityInstance: MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityInstance = this
        setContent {
            FootGeneralQuizTheme {
                Navigation()
            }
        }
    }
}