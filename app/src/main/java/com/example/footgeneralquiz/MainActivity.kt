package com.example.footgeneralquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
