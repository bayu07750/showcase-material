package com.bayu.transitionnavigation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bayu.transitionnavigation.databinding.FragmentDetailBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }
}