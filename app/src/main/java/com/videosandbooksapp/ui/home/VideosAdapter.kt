package com.videosandbooksapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.videosandbooksapp.R
import com.videosandbooksapp.databinding.VideoItemBinding
import com.videosandbooksapp.models.Videos
import com.videosandbooksapp.setImage


class VideosAdapter(val onClickListener: VideoClickListener) : ListAdapter<Videos, VideosAdapter.VideoViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)
        holder.bind(video)
        holder.itemView.setOnClickListener { video?.let { onClickListener.onClick(it) } }


    }

    class VideoViewHolder private constructor(val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(videos: Videos) {
            binding.video = videos
            binding.executePendingBindings()
            val icon = if (videos?.type == "VIDEO") {
                R.drawable.ic_baseline_videocam_24
            } else R.drawable.ic_baseline_picture_as_pdf_24

            setImage(binding.icon, icon)
        }

        companion object {
            fun from(parent: ViewGroup): VideoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = VideoItemBinding.inflate(layoutInflater, parent, false)
                return VideoViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minumum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class MovieDiffCallback : DiffUtil.ItemCallback<Videos>() {
    override fun areItemsTheSame(oldItem: Videos, newItem: Videos): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Videos, newItem: Videos): Boolean {
        return oldItem == newItem
    }
}

    class VideoClickListener(val onClick: (video:Videos) -> Unit)

