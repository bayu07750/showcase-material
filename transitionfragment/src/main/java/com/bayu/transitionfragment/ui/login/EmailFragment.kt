package com.bayu.transitionfragment.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentEmailBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class EmailFragment : BaseFragment<FragmentEmailBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEmailBinding {
        return FragmentEmailBinding.inflate(inflater, container, false)
    }
}