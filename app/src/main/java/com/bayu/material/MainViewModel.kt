package com.bayu.material

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _title = MutableStateFlow("Home")
    val title: StateFlow<String> = _title

    fun setTItle(value: String) {
        _title.value = value
    }

}