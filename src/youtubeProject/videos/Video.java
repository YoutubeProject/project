package youtubeProject.videos;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Video {
    public youtubeProject.videos.Statistics statistics;

}