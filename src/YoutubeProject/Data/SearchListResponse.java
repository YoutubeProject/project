package YoutubeProject.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchListResponse {
    public List<SearchResult> items;
}
