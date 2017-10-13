package youtubeProject.channels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Snippet {
    public String title;
    public String publishedAt;
}