package com.bayu.transitionnavigation.ui

import androidx.lifecycle.ViewModel
import com.bayu.transitionnavigation.data.Data
import com.bayu.transitionnavigation.data.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private var _photos = MutableStateFlow(Data.photos)
    val photos: StateFlow<List<Photo>> = _photos

}