package com.bayu.transitionnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bayu.transitionnavigation.R
import com.bayu.transitionnavigation.data.Photo
import com.bayu.transitionnavigation.databinding.FragmentHomeBinding
import com.bayu.transitionnavigation.ui.adapter.PhotosAdapter
import com.bayu.transitionnavigation.ui.base.BaseFragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        observe()
        actions()
    }

    private fun initView() {
        photosAdapter = PhotosAdapter(
            onItemPhotoClicked = onItemPhotoClicked,
        )

        setupRvPhotos(listTypeGrid)
    }

    private val onItemPhotoClicked: (Photo, String, View) -> Unit = { photo, transitionName, _ ->
        val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            photo, transitionName
        )
        findNavController().navigate(directions)
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                viewModel.photos.collect { photos ->
                    photosAdapter.submitList(photos)
                }
            }
        }
    }

    private fun actions() {
        with(binding) {
            floatingActionButton.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddFragment())
            }

            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menuListType -> {
                        setupRvPhotos(!listTypeGrid)
                        true
                    }
                    R.id.menuLogin -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEmailFragment())
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun setupRvPhotos(listTypeGrid: Boolean) {
        this.listTypeGrid = listTypeGrid

        val rv = createRvPhotos(listTypeGrid)

        rv.adapter = photosAdapter

        with(binding.listContainer) {
            removeAllViews()
            addView(rv)
        }
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
    }
}