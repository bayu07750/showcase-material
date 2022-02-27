package com.bayu.transitionfragment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentHomeBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    companion object {
        val TAG: String = HomeFragment::class.java.simpleName

        fun getInstance(): HomeFragment = HomeFragment()
    }
}