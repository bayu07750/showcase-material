package com.bayu.transitionfragment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionfragment.databinding.FragmentDetailBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }
}