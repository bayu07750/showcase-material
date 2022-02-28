package com.bayu.transitionfragment.ui

import androidx.lifecycle.ViewModel
import com.bayu.transitionfragment.data.Data
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private var _photos = MutableStateFlow(Data.photos)
    val photos: StateFlow<List<String>> = _photos

}