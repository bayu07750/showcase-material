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
    }

    companion object {
        private const val PHOTO_KEY = "photo_key"

        val TAG: String = DetailFragment::class.java.simpleName

        fun getInstance(photo: String): DetailFragment {
            val bundle = bundleOf(PHOTO_KEY to photo)
            return DetailFragment().apply {
                arguments = bundle
            }
        }
    }
}