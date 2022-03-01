package com.bayu.transitionfragment.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentPasswordBinding
import com.bayu.transitionfragment.ui.base.BaseFragment
import com.google.android.material.transition.MaterialSharedAxis

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

    companion object {
        val TAG: String = PasswordFragment::class.java.simpleName

        fun getInstance(): PasswordFragment = PasswordFragment()
    }
}