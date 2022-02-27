package com.bayu.transitionfragment

import android.view.LayoutInflater
import com.bayu.transitionfragment.databinding.ActivityMainBinding
import com.bayu.transitionfragment.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateLayout(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}