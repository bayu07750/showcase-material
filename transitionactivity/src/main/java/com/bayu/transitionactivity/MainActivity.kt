package com.bayu.transitionactivity

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.bayu.transitionactivity.databinding.ActivityMainBinding
import com.bayu.transitionactivity.login.EmailActivity
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class MainActivity : AppCompatActivity() {

    companion object {
        private const val GRID_SPAN_COUNT = 2
        private val PHOTO_RECYCLE_VIEW_ID = ViewCompat.generateViewId()
    }

    private var listTypeGrid = true

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setupTransitionTransformContainer()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        actions()
    }

    private fun initView() {
        adapter = PhotosAdapter(photos = Data.photos, onItemPhotoCLicked = onItemPhotoClicked)

        val sharedExis = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        setList(listTypeGrid, sharedExis)
    }

    private fun actions() {
        binding.floatingActionButton.setOnClickListener {
            resetTransition()

            val intent = Intent(this, DetailActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                it,
                getString(R.string.shared_element_desc)
            )
            startActivity(intent, options.toBundle())
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menuLogin -> {
                    setupTransition()
                    val options = ActivityOptions.makeSceneTransitionAnimation(this)
                    val intent = Intent(this, EmailActivity::class.java)
                    startActivity(intent, options.toBundle())
                    true
                }
                R.id.menuListType -> {
                    val fadeThrough = MaterialFadeThrough()
                    setList(!listTypeGrid, fadeThrough)
                    true
                }
                else -> false
            }
        }
    }

    private fun setList(listTypeGrid: Boolean, transition: Transition) {
        this.listTypeGrid = listTypeGrid

        val rv = createRecyclerView(listTypeGrid)

        transition.addTarget(rv)

        val currentRv = binding.listContainer.getChildAt(0)
        if (currentRv != null) {
            transition.addTarget(currentRv)
        }

        TransitionManager.beginDelayedTransition(binding.listContainer, transition)

        rv.adapter = this.adapter

        binding.listContainer.removeAllViews()
        binding.listContainer.addView(rv)
    }

    private fun createRecyclerView(listTypeGrid: Boolean): RecyclerView {
        return RecyclerView(this).apply {
            id = PHOTO_RECYCLE_VIEW_ID
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setPadding(
                resources.getDimensionPixelSize(R.dimen.medium),
                resources.getDimensionPixelSize(R.dimen.medium),
                0,
                0
            )
            clipToPadding = false
            layoutManager = if (listTypeGrid) {
                StaggeredGridLayoutManager(GRID_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
            } else {
                LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private val onItemPhotoClicked: (String, View) -> Unit = { photo, view ->
        resetTransition()

        val intent = Intent(this, DetailPhotoActivity::class.java).apply {
            putExtra(DetailPhotoActivity.EXTRA_PHOTO, photo)
        }
        val options = ActivityOptions.makeSceneTransitionAnimation(
            this,
            view,
            getString(R.string.photoTransitionDesc)
        )
        startActivity(intent, options.toBundle())
    }

    private fun setupTransitionTransformContainer() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        // Set up shared element transition and disable overlay so views don't show above system bars
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
    }

    private fun setupTransition() {
        val axis = com.google.android.material.transition.platform.MaterialSharedAxis.Z

        val exitTransition =
            com.google.android.material.transition.platform.MaterialSharedAxis(axis, true)
        exitTransition.addTarget(R.id.rootMain)
        window.exitTransition = exitTransition

        val reenterTransition =
            com.google.android.material.transition.platform.MaterialSharedAxis(axis, false)
        reenterTransition.addTarget(R.id.rootMain)
        window.reenterTransition = reenterTransition
    }

    private fun resetTransition() {
        window.exitTransition = null
        window.reenterTransition = null
    }
}