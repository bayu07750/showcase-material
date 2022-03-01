package com.bayu.transitionfragment.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bayu.transitionfragment.databinding.FragmentLoginBinding
import com.bayu.transitionfragment.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.commit {
            add(
                binding.fragmentLoginContainerView.id,
                EmailFragment.getInstance(),
                EmailFragment.TAG
            )
            setReorderingAllowed(true)
        }
    }

    companion object {
        val TAG: String = LoginFragment::class.java.simpleName

        fun getInstance(): LoginFragment = LoginFragment()
    }
}