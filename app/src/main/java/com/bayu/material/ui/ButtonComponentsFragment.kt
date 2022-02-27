package com.bayu.material.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bayu.material.MainViewModel
import com.bayu.material.databinding.FragmentButtonComponentsBinding

class ButtonComponentsFragment : BaseFragment<FragmentButtonComponentsBinding>() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentButtonComponentsBinding {
        return FragmentButtonComponentsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setTItle("Button Components")
    }

    companion object {
        internal val TAG = ButtonComponentsFragment::class.java.simpleName

        fun getInstance(): ButtonComponentsFragment = ButtonComponentsFragment()
    }
}