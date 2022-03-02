package com.bayu.transitionnavigation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bayu.transitionnavigation.data.Photo
import com.bayu.transitionnavigation.databinding.ItemPhotoBinding

class PhotosAdapter(
    private val onItemPhotoClicked: (Photo, String, View) -> Unit,
) : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(DIFF_CALLBACK) {

    inner class PhotoViewHolder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.ivPhoto.load(photo.url) {
                crossfade(true)
            }

            val tm = photo.name.lowercase() + "_transition"
            binding.root.transitionName = tm

            binding.root.setOnClickListener { view ->
                onItemPhotoClicked.invoke(photo, tm, view)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                ),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

}