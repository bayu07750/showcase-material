package com.bayu.transitionfragment.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentLoginBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    companion object {
        val TAG: String = LoginFragment::class.java.simpleName

        fun getInstance(): LoginFragment = LoginFragment()
    }
}