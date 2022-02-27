package com.bayu.transitionactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bayu.transitionactivity.databinding.ItemPhotosBinding

class PhotosAdapter(
    private val photos: List<String>,
    private val onItemPhotoCLicked: (String, View) -> Unit,
) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    inner class PhotosViewHolder(
        private val binding: ItemPhotosBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: String) {
            binding.ivPhoto.load(photo) {
                crossfade(true)
            }
            binding.ivPhoto.setOnClickListener { onItemPhotoCLicked.invoke(photo, it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            ItemPhotosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size
}