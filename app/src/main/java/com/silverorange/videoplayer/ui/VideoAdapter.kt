package com.silverorange.videoplayer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silverorange.videoplayer.R
import com.silverorange.videoplayer.data.remote.Video

class VideoAdapter : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    private val videos = mutableListOf<Video>()

    fun setVideos(videos: List<Video>) {
        this.videos.clear()
        this.videos.addAll(videos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        holder.bind(video)
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(video: Video) {
            // Bind video details to views in the item layout
        }
    }
}
