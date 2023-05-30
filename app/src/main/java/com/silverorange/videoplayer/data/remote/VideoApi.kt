package com.silverorange.videoplayer.data.remote

import VideoResponse
import retrofit2.http.GET

interface VideoService {
    @GET("videos")
    suspend fun getVideos(): VideoResponse
}