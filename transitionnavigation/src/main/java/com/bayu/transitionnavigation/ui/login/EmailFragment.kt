package com.bayu.transitionnavigation.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionnavigation.databinding.FragmentEmailBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment

class EmailFragment : BaseFragment<FragmentEmailBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEmailBinding {
        return FragmentEmailBinding.inflate(inflater, container, false)
    }
}