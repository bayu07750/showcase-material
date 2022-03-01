package com.bayu.transitionfragment.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bayu.transitionfragment.R
import com.bayu.transitionfragment.databinding.FragmentEmailBinding
import com.bayu.transitionfragment.ui.base.BaseFragment
import com.google.android.material.transition.MaterialSharedAxis

class EmailFragment : BaseFragment<FragmentEmailBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEmailBinding {
        return FragmentEmailBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actions()
    }

    private fun actions() {
        with(binding) {
            btnNext.setOnClickListener {
                val passwordFragment = PasswordFragment.getInstance()
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_view, passwordFragment, PasswordFragment.TAG)
                    addToBackStack(null)
                    setReorderingAllowed(true)
                }
            }
        }
    }

    companion object {
        val TAG: String = EmailFragment::class.java.simpleName

        fun getInstance(): EmailFragment = EmailFragment()
    }
}