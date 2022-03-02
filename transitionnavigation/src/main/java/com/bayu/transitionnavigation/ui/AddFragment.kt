package com.bayu.transitionnavigation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionnavigation.databinding.FragmentAddBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment

class AddFragment : BaseFragment<FragmentAddBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddBinding {
        return FragmentAddBinding.inflate(inflater, container, false)
    }
}