package com.example.footgeneralquiz.ui.choiceLevelScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.footgeneralquiz.data.Level

class ChoiceLevelViewModel : ViewModel() {

    // level response
    private val _levelResponse = mutableStateOf<Level?>(null)
    val levelResponse: Level?
        get() = _levelResponse.value

    // next button
    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    /**
     * Function implementation
     */
    fun onLevelResponse(level: Level) {
        _levelResponse.value = level
        _isNextEnabled.value = getIsNextEnabled()
    }

    private fun getIsNextEnabled(): Boolean {
        return _levelResponse.value != null
    }
}
