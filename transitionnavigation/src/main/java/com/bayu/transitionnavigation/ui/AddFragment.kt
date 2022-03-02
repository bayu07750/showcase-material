package com.bayu.transitionnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionnavigation.databinding.FragmentAddBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment
import com.google.android.material.transition.platform.MaterialContainerTransform

class AddFragment : BaseFragment<FragmentAddBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddBinding {
        return FragmentAddBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
    }
}