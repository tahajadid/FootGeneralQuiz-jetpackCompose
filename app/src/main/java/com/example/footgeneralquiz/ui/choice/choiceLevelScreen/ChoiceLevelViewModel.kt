package com.example.footgeneralquiz.ui.choice.choiceLevelScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.footgeneralquiz.data.Choice
import com.example.footgeneralquiz.data.Level

class ChoiceLevelViewModel : ViewModel() {

    /**
     * Variables
     */
    private val _levelResponse = mutableStateOf<Level?>(null)
    val levelResponse: Level?
        get() = _levelResponse.value

    private val _choiceResponse = mutableStateOf<Choice?>(null)
    val choiceResponse: Choice?
        get() = _choiceResponse.value

    private val _isStartEnabled = mutableStateOf(false)
    val isStartEnabled: Boolean
        get() = _isStartEnabled.value

    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    /**
     * Function implementation
     */
    fun onLevelResponse(level: Level) {
        _levelResponse.value = level
        _isStartEnabled.value = getIsStartEnabled()
    }

    fun onChoiceResponse(level: Level) {
        _levelResponse.value = level
        _isNextEnabled.value = getIsNextEnabled()
    }
    private fun getIsStartEnabled(): Boolean {
        return _levelResponse.value != null
    }

    private fun getIsNextEnabled(): Boolean {
        return _choiceResponse.value != null
    }
}
