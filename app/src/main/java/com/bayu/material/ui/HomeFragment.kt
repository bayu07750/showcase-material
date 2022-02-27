package com.bayu.material.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.bayu.material.MainViewModel
import com.bayu.material.R
import com.bayu.material.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(), View.OnClickListener {

    private val viewModel: MainViewModel by activityViewModels()

    private var isFabAddShow = true

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setTItle("Home")

        with(binding) {
            btnShowcaseBtnComponents.setOnClickListener(this@HomeFragment)
            btnShowcaseTextStyles.setOnClickListener(this@HomeFragment)
            btnToggleFabAdd.setOnClickListener(this@HomeFragment)
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnShowcaseBtnComponents -> {
                parentFragmentManager.commit {
                    replace(
                        R.id.fragmentContainerView,
                        ButtonComponentsFragment.getInstance(),
                        ButtonComponentsFragment.TAG
                    )
                    addToBackStack(null)
                    setReorderingAllowed(true)
                }
            }
            binding.btnShowcaseTextStyles -> {
                parentFragmentManager.commit {
                    replace(
                        R.id.fragmentContainerView,
                        TextStylesFragment.getInstance(),
                        TextStylesFragment.TAG
                    )
                    addToBackStack(null)
                    setReorderingAllowed(true)
                }
            }
            binding.btnToggleFabAdd -> {
                if (isFabAddShow) {
                    isFabAddShow = false
                    binding.floatingActionButton.hide()
                } else {
                    isFabAddShow = true
                    binding.floatingActionButton.show()
                }
            }
        }
    }

    companion object {
        internal val TAG = HomeFragment::class.java.simpleName

        fun getInstance(): HomeFragment = HomeFragment()
    }
}