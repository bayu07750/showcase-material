package com.bayu.transitionfragment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentAddBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class AddFragment : BaseFragment<FragmentAddBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddBinding {
        return FragmentAddBinding.inflate(inflater, container, false)
    }
}