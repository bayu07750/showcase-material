package com.bayu.transitionfragment.adapater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bayu.transitionfragment.databinding.ItemPhotoBinding
import java.util.*

class PhotosAdapter(
    private val onItemPhotoClicked: (String, String, View) -> Unit,
) : ListAdapter<String, PhotosAdapter.PhotoViewHolder>(DIFF_CALLBACK) {

    inner class PhotoViewHolder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: String) {
            val transitionName = UUID.randomUUID().toString()

            binding.root.transitionName = transitionName
            binding.root.setOnClickListener { onItemPhotoClicked.invoke(photo, transitionName, it) }
            binding.ivPhoto.load(photo) {
                crossfade(true)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
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