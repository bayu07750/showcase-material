package com.bayu.transitionnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.bayu.transitionnavigation.R
import com.bayu.transitionnavigation.databinding.FragmentDetailBinding
import com.bayu.transitionnavigation.ui.base.BaseFragment
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialContainerTransform

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val args: DetailFragmentArgs by navArgs()

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            setAllContainerColors(
                MaterialColors.getColor(
                    requireContext(),
                    com.google.android.material.R.attr.colorSurface,
                    resources.getColor(R.color.white)
                )
            )
        }
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

        binding.root.transitionName = transitionName
        binding.toolbar.title = "Detail Photo ${photo.name}"
        binding.ivPhoto.load(photo.url) {
            crossfade(true)
        }
    }
}