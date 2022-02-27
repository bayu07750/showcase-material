package com.bayu.transitionactivity

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.bayu.transitionactivity.databinding.ActivityDetailPhotoBinding
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class DetailPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPhotoBinding.inflate(layoutInflater)

        setupTransitionTransformContainer()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        actions()
    }

    private fun initView() {
        val photo = intent.getStringExtra(EXTRA_PHOTO) ?: return
        binding.contentDetailPhoto.ivPhoto.load(photo) {
            crossfade(true)
        }
    }

    private fun actions() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupTransitionTransformContainer() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        findViewById<View>(android.R.id.content).transitionName =
            getString(R.string.photoTransitionDesc)
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = buildContainerTransform(true)
        window.sharedElementReturnTransition = buildContainerTransform(false)
    }

    private fun buildContainerTransform(entering: Boolean): MaterialContainerTransform {
        val transform = MaterialContainerTransform(this, entering)

        // Use all 3 container layer colors since this transform can be configured using any fade mode
        // and some of the start views don't have a background and the end view doesn't have a
        // background.
        transform.setAllContainerColors(
            MaterialColors.getColor(
                findViewById(android.R.id.content),
                com.google.android.material.R.attr.colorSurface
            )
        )
        transform.addTarget(android.R.id.content)
        return transform
    }

    companion object {
        internal const val EXTRA_PHOTO = "photo"
    }
}