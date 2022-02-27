package com.bayu.transitionactivity.login

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.bayu.transitionactivity.R
import com.bayu.transitionactivity.databinding.ActivityPasswordBinding
import com.google.android.material.transition.platform.MaterialSharedAxis

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setupTransition()

        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupTransition() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        val enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        enterTransition.addTarget(R.id.rootPassword)
        window.enterTransition = enterTransition

        val returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        returnTransition.addTarget(R.id.rootPassword)
        window.returnTransition = returnTransition
    }
}