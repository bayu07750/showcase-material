package com.bayu.material.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bayu.material.MainViewModel
import com.bayu.material.databinding.FragmentTextStylesBinding

class TextStylesFragment : BaseFragment<FragmentTextStylesBinding>() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTextStylesBinding {
        return FragmentTextStylesBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setTItle("Text Styles")
    }

    companion object {
        internal val TAG = TextStylesFragment::class.java.simpleName

        fun getInstance(): TextStylesFragment = TextStylesFragment()
    }
}