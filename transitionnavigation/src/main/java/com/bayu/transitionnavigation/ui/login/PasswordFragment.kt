package com.bayu.transitionnavigation.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionnavigation.databinding.FragmentPasswordBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment

class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPasswordBinding {
        return FragmentPasswordBinding.inflate(inflater, container, false)
    }
}