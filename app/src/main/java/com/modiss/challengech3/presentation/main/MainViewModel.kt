package com.modiss.challengech3.presentation.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val userPreferenceDataSource: UserPreferenceDataSource) : ViewModel() {
    val userDarkModeLiveData = userPreferenceDataSource.getUserDarkModePrefFlow().asLiveData(
        Dispatchers.IO)
}

class UserPreferenceDataSource {
    fun getUserDarkModePrefFlow(): Any {
    }

}
