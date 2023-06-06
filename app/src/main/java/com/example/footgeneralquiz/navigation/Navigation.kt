package com.example.footgeneralquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.footgeneralquiz.ui.choiceTypeScreen.ChoiceTypeScreen
import com.example.footgeneralquiz.ui.splashScreen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.ChoiceTypeScreen.route) {
            ChoiceTypeScreen(navController = navController)
        }

        /*
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Test"
                    nullable = true
                }
            )
        ) {
            DetailScreen(name = it.arguments?.getString("name").toString())
        }

         */
    }
}
