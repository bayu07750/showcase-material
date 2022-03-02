package com.bayu.transitionnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.bayu.transitionnavigation.databinding.FragmentDetailBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val args: DetailFragmentArgs by navArgs()

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        actions()
    }

    private fun actions() {
        with(binding) {
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun initView() {
        val photo = args.photo
        val transitionName = args.transitionName

        binding.toolbar.title = "Detail Photo ${photo.name}"
        binding.ivPhoto.load(photo.url) {
            crossfade(true)
        }
    }
}