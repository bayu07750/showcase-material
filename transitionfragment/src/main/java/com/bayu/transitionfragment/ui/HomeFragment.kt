package com.bayu.transitionfragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.bayu.transitionfragment.R
import com.bayu.transitionfragment.adapater.PhotosAdapter
import com.bayu.transitionfragment.databinding.FragmentHomeBinding
import com.bayu.transitionfragment.ui.base.BaseFragment
import com.bayu.transitionfragment.ui.login.LoginFragment
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var photosAdapter: PhotosAdapter

    private var listTypeGrid = true

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        actions()
        observe()
    }

    private fun initView() {
        photosAdapter = PhotosAdapter(
            onItemPhotoClicked = onItemPhotoClicked,
        )

        val transition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
        setList(listTypeGrid, transition)
    }

    private fun actions() {
        with(binding) {
            floatingActionButton.setOnClickListener {
                val addFragment = AddFragment.getInstance().apply {
                    sharedElementEnterTransition = MaterialContainerTransform()
                }
                parentFragmentManager.commit {
                    addSharedElement(it, resources.getString(R.string.shared_element_fab))
                    replace(R.id.fragment_container_view, addFragment, AddFragment.TAG)
                    addToBackStack(null)
                    setReorderingAllowed(true)
                }
            }

            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menuListType -> {
                        val fadeThroughTransition = MaterialFadeThrough()
                        setList(!listTypeGrid, fadeThroughTransition)
                        true
                    }
                    R.id.menuLogin -> {
                        val loginFragment = LoginFragment.getInstance()
                        parentFragmentManager.commit {
                            replace(R.id.fragment_container_view, loginFragment, LoginFragment.TAG)
                            addToBackStack(null)
                            setReorderingAllowed(true)
                        }
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                viewModel.photos.collect {
                    if (it.isNotEmpty()) {
                        photosAdapter.submitList(it)
                    }
                }
            }
        }
    }

    private val onItemPhotoClicked: (String, String, View) -> Unit =
        { photo, transitionName, view ->
            val transform = MaterialContainerTransform(requireContext(), true).apply {
                setAllContainerColors(
                    MaterialColors.getColor(
                        binding.rootMain,
                        com.google.android.material.R.attr.colorSurface
                    )
                )
            }

            val detailFragment = DetailFragment.getInstance(photo, transitionName).apply {
                sharedElementEnterTransition = transform
            }

            parentFragmentManager.commit {
                addSharedElement(view, transitionName)
                replace(R.id.fragment_container_view, detailFragment, DetailFragment.TAG)
                addToBackStack(null)
                setReorderingAllowed(true)
            }
        }

    private fun setList(listTypeGrid: Boolean, transition: Transition) {
        this.listTypeGrid = listTypeGrid

        val rv = createRvPhotos(listTypeGrid)

        transition.addTarget(rv)

        val currentRv = binding.listContainer.getChildAt(0)
        if (currentRv != null) {
            transition.addTarget(currentRv)
        }

        TransitionManager.beginDelayedTransition(binding.listContainer, transition)

        rv.adapter = photosAdapter

        binding.listContainer.removeAllViews()
        binding.listContainer.addView(rv)
    }

    private fun createRvPhotos(listTypeGrid: Boolean): RecyclerView {
        return RecyclerView(requireContext()).apply {
            id = RV_PHOTOS_ID
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val pad = resources.getDimensionPixelSize(R.dimen.medium_padding)
            setPadding(
                pad,
                pad,
                0,
                0,
            )
            clipToPadding = false
            layoutManager = if (listTypeGrid) {
                StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            } else {
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            }
        }
    }

    companion object {
        private val RV_PHOTOS_ID = ViewCompat.generateViewId()
        val TAG: String = HomeFragment::class.java.simpleName

        fun getInstance(): HomeFragment = HomeFragment()
    }
}