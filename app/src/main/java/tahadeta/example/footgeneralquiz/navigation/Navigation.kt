package tahadeta.example.footgeneralquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tahadeta.example.footgeneralquiz.ui.choice.choiceLevelScreen.ChoiceLevelScreen
import tahadeta.example.footgeneralquiz.ui.choice.choiceTypeScreen.ChoiceTypeScreen
import tahadeta.example.footgeneralquiz.ui.splash.SplashScreen
import tahadeta.example.footgeneralquiz.ui.survey.SurveyRoute
import tahadeta.example.footgeneralquiz.ui.survey.surveyScreen.SurveyResultScreen

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

        composable(route = Screen.ChoiceLevelScreen.route) {
            ChoiceLevelScreen(navController = navController)
        }

        composable(route = Screen.SurveyScreen.route) {
            SurveyRoute(
                navController = navController,
                onNavUp = navController::navigateUp
            )
        }

        composable(
            route = Screen.ResultScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "0"
                    nullable = false
                }
            )
        ) {
            SurveyResultScreen(
                onDonePressed = {
                    navController.navigate(Screen.ChoiceTypeScreen.route) {
                        popUpTo(0)
                    }
                },
                result = it.arguments?.getString("name").toString()
            )
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
