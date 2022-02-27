package com.bayu.transitionactivity.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.bayu.transitionactivity.R
import com.bayu.transitionactivity.databinding.ActivityEmailBinding
import com.google.android.material.transition.platform.MaterialSharedAxis

class EmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setupTransition()

        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actions()
    }

    private fun setupTransition() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        val zAxis = MaterialSharedAxis.Z

        val enterTransition = MaterialSharedAxis(zAxis, true)
        enterTransition.addTarget(R.id.rootEmail)
        window.enterTransition = enterTransition

        val returnTransition = MaterialSharedAxis(zAxis, false)
        returnTransition.addTarget(R.id.rootEmail)
        window.returnTransition = returnTransition

        val yAxis = MaterialSharedAxis.X

        val exitTransition = MaterialSharedAxis(yAxis, true)
        exitTransition.addTarget(R.id.rootEmail)
        window.exitTransition = exitTransition

        val reenterTransition = MaterialSharedAxis(yAxis, false)
        reenterTransition.addTarget(R.id.rootEmail)
        window.reenterTransition = reenterTransition
    }

    private fun actions() {
        binding.btnNext.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent, options.toBundle())
        }
    }
}