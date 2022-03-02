package com.bayu.transitionnavigation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionnavigation.databinding.FragmentPasswordBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment
import com.google.android.material.transition.platform.MaterialSharedAxis

class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPasswordBinding {
        return FragmentPasswordBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }
}