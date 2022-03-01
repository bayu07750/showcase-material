package com.bayu.transitionfragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import coil.load
import com.bayu.transitionfragment.databinding.FragmentDetailBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

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
            toolbar.setNavigationOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
    }

    private fun initView() {
        val photo = requireArguments().getString(PHOTO_KEY) ?: ""
        binding.contentDetailPhoto.ivPhoto.load(photo) {
            crossfade(true)
        }

        val transitionName = requireArguments().getString(KEY_TRANSITION_NAME)
        binding.root.transitionName = transitionName
    }

    companion object {
        private const val PHOTO_KEY = "photo_key"
        private const val KEY_TRANSITION_NAME = "photo_transition"

        val TAG: String = DetailFragment::class.java.simpleName

        fun getInstance(photo: String, transitionName: String): DetailFragment {
            val bundle = bundleOf(PHOTO_KEY to photo, KEY_TRANSITION_NAME to transitionName)
            return DetailFragment().apply {
                arguments = bundle
            }
        }
    }
}