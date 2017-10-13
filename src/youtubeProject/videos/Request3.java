package youtubeProject.videos;



import youtubeProject.channels.Request1;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Request3 {

    public static VideoListResponse requestVideoDataAsObject(String videosList, String apiKey) throws UnirestException {
        Request1.initApplication();
        HttpResponse<VideoListResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/videos")
                .queryString("id", videosList)
                .queryString("part", "statistics")
                .queryString("fields", "items(statistics(commentCount))")
                .queryString("key", apiKey)
                .asObject(VideoListResponse.class);
        return response.getBody();
    }

}