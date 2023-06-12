package com.example.footgeneralquiz.navigation

sealed class Screen(val route: String) {

    object SplashScreen : Screen("splash_screen")
    object ChoiceTypeScreen : Screen("choice_type_screen")

    object ChoiceLevelScreen : Screen("choice_level_screen")

    object SurveyScreen : Screen("survey_screen")
    object ResultScreen : Screen("result_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
