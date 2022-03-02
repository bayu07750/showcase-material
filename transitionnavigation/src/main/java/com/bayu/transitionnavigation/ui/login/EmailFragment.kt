package com.bayu.transitionnavigation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bayu.transitionnavigation.databinding.FragmentEmailBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment

class EmailFragment : BaseFragment<FragmentEmailBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEmailBinding {
        return FragmentEmailBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actions()
    }

    private fun actions() {
        with(binding) {
            btnNext.setOnClickListener {
                findNavController().navigate(EmailFragmentDirections.actionEmailFragmentToPasswordFragment())
            }
        }
    }
}