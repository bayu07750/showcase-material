package com.bayu.transitionfragment.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun inflateLayout(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = inflateLayout(layoutInflater)

        doBeforeSuperOnCreate()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    open fun doBeforeSuperOnCreate() {}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}