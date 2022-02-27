package com.bayu.transitionfragment.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentPasswordBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPasswordBinding {
        return FragmentPasswordBinding.inflate(inflater, container, false)
    }

    companion object {
        val TAG: String = PasswordFragment::class.java.simpleName

        fun getInstance(): PasswordFragment = PasswordFragment()
    }
}