package com.example.footgeneralquiz.util

import com.example.footgeneralquiz.data.Choice
import com.example.footgeneralquiz.data.Level

object Constants {

    var LIST_OF_CHOICES = arrayListOf(
        Choice(0, "World Cup", "", false),
        Choice(1, "Teams", "", false),
        Choice(2, "Champions League EU", "", false),
        Choice(3, "Champions League AF", "", false),
        Choice(4, "Players", "", false),
        Choice(5, "Flags", "", false),
        Choice(6, "", "", false),
        Choice(7, "Diverse", "", false)
    )

    var LIST_OF_LEVELS = arrayListOf(
        Level(0, "Level 1"),
        Level(1, "Level 2"),
        Level(2, "Level 3")
    )
}
