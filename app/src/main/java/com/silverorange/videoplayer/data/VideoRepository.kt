import com.silverorange.videoplayer.data.remote.Video
import com.silverorange.videoplayer.data.remote.VideoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface VideoRepository {
    suspend fun fetchVideos(): List<Video>
}

class VideoRepositoryImpl : VideoRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:4000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val videoService = retrofit.create(VideoService::class.java)

    override suspend fun fetchVideos(): List<Video> {
        return videoService.getVideos().videos
    }
}



data class VideoResponse(
    val videos: List<Video>
)
