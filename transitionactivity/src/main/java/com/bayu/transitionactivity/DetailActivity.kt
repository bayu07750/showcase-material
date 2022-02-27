package com.bayu.transitionactivity

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.bayu.transitionactivity.databinding.ActivityDetailBinding
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        binding.root.transitionName = getString(R.string.shared_element_desc)

        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        window.sharedElementEnterTransition = buildContainerTransform(true)
        window.sharedElementReturnTransition = buildContainerTransform(false)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun buildContainerTransform(entering: Boolean): MaterialContainerTransform {
        val transform = MaterialContainerTransform(this, entering)

        transform.setAllContainerColors(
            MaterialColors.getColor(binding.root, com.google.android.material.R.attr.colorSurface)
        )
        transform.addTarget(binding.root)
        return transform
    }
}