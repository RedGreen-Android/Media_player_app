package com.silverorange.videoplayer.ui

import VideoRepository
import VideoRepositoryImpl
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silverorange.videoplayer.data.remote.Video
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel() {
    private val videoRepository: VideoRepository = VideoRepositoryImpl()
    private val _videos = MutableLiveData<List<Video>>()

    val videos: LiveData<List<Video>>
        get() = _videos

    fun fetchVideos() {
        viewModelScope.launch {
            _videos.value = videoRepository.fetchVideos()
        }
    }
}
