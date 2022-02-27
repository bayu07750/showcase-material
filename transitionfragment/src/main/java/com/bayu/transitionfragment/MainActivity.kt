package com.bayu.transitionfragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.commit
import com.bayu.transitionfragment.databinding.ActivityMainBinding
import com.bayu.transitionfragment.ui.HomeFragment
import com.bayu.transitionfragment.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateLayout(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(
                    binding.fragmentContainerView.id,
                    HomeFragment.getInstance(),
                    HomeFragment.TAG
                )
                setReorderingAllowed(true)
            }
        }
    }
}