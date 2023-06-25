package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.Choice
import com.example.footgeneralquiz.data.Level

object Constants {

    var LIST_OF_CHOICES = arrayListOf(
        Choice(0, "World Cup", "WORLD_CUP"),
        Choice(1, "EUFA", "LEAGUE_EU"),
        Choice(2, "Players", "PLAYERS"),
        Choice(3, "Teams", "TEAMS"),
        Choice(4, "Flags", "FLAGS")
    )

    // to be added later
    /**
     Choice(3, "Champions League AF", "LEAGUE_AF"),
     Choice(7, "Various", "VARIOUS")
     */

    var LIST_OF_THREE_LEVELS = arrayListOf(
        Level(0, "Level 1"),
        Level(1, "Level 2"),
        Level(2, "Level 3")
    )

    var LIST_OF_TWO_LEVELS = arrayListOf(
        Level(0, "Level 1"),
        Level(1, "Level 2")
    )
}
