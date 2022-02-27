package com.bayu.transitionfragment.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: VB? = null
    private val binding get() = _binding!!

    abstract fun inflateLayout(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        _binding = inflateLayout(layoutInflater)

        doBeforeSuperOnCreate()

        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }

    open fun doBeforeSuperOnCreate() {}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}