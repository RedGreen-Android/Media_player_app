package com.silverorange.videoplayer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.silverorange.videoplayer.ui.VideoAdapter
import com.silverorange.videoplayer.ui.VideoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var videoPlayer: SimpleExoPlayer
    private lateinit var videoViewModel: VideoViewModel
    private lateinit var videoAdapter: VideoAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoPlayer = SimpleExoPlayer.Builder(this).build()
        val playerView: PlayerView = findViewById(R.id.exoPlayerFrameLayout)
        playerView.player = videoPlayer

        videoAdapter = VideoAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = videoAdapter

        videoViewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        videoViewModel.videos.observe(this) { videos ->
            videoAdapter.setVideos(videos)
        }

        videoViewModel.fetchVideos()
    }

    override fun onDestroy() {
        super.onDestroy()
        videoPlayer.release()
    }
}
