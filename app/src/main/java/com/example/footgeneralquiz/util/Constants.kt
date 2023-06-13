package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.Choice
import com.example.footgeneralquiz.data.Level

object Constants {

    var LIST_OF_CHOICES = arrayListOf(
        Choice(0, "World Cup", "WORLD_CUP", false),
        Choice(1, "Teams", "TEAMS", false),
        Choice(2, "Champions League EU", "LEAGUE_EU", false),
        Choice(3, "Champions League AF", "LEAGUE_AF", false),
        Choice(4, "Players", "PLAYERS", false),
        Choice(5, "Flags", "FLAGS", false),
        Choice(6, "Awards", "AWARDS", false),
        Choice(7, "Various", "VARIOUS", false)
    )

    var LIST_OF_LEVELS = arrayListOf(
        Level(0, "Level 1"),
        Level(1, "Level 2"),
        Level(2, "Level 3")
    )
}
