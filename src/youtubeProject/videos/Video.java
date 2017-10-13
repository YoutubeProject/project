package YoutubeProject.Videos;



import YoutubeProject.Channels.Statistics;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Video {
    public YoutubeProject.Videos.Statistics statistics;

}