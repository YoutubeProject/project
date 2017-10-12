package YoutubeProject.Channels;

import YoutubeProject.Data.Request2;
import YoutubeProject.Data.SearchListResponse;
import YoutubeProject.Data.SearchResult;
import YoutubeProject.Videos.Request3;
import YoutubeProject.Videos.VideoListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Request1 {

    public static void main(String[] args) throws UnirestException {
        SearchListResponse searchListResponse = Request2.requestSearchVideosListAsObject(channelId, myApiKey);
        StringBuilder videosList = new StringBuilder();
        for (SearchResult i : searchListResponse.items) {
            videosList.append(i.id.videoId);
            videosList.append(",");
        }


    VideoListResponse videoListResponse = Request3.requestVideoDataAsObject(videosList.toString(),myApiKey);
        System.out.println(videoListResponse.countComments());
    }


    static String channelId = "UCJALCpMORvQrlN7dAPLiCWg";
    static String myApiKey = "AIzaSyBifuUatBiNP7C8X2zjMM1BJWinnrES6Ic";

    public static OneChannel getYouTubeChannelAsObject(String channelId) throws UnirestException {
        ChannelListResponse channelsResponse = requestChannelDataAsObject(channelId);
        return channelsResponse.items.get(0);
    }
    public static ChannelListResponse getYouTubeChannelResponseAsObject(String channelId) throws UnirestException {
        return requestChannelDataAsObject(channelId);
    }

    public static String getChannelDataAsString(String channelId) throws UnirestException {
        System.out.println("Channel data successfully retrieved from server.");
        return requestChannelDataAsString(channelId);
    }

    public static void initApplication() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private static ChannelListResponse requestChannelDataAsObject(String channelId) throws UnirestException {
        initApplication();
        HttpResponse<ChannelListResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/channels")
                .queryString("id", channelId)
                .queryString("part", "snippet,statistics")
                .queryString("fields", "items(snippet(title,publishedAt),statistics(viewCount,subscriberCount,videoCount))")
                .queryString("key", myApiKey)
                .asObject(ChannelListResponse.class);
        return response.getBody();
    }
    private static String requestChannelDataAsString(String channelId) throws UnirestException {
        initApplication();
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/channels")
                .queryString("id", channelId)
                .queryString("part", "snippet,statistics")
                .queryString("fields", "items(snippet(title,publishedAt),statistics(viewCount,subscriberCount,videoCount))")
                .queryString("maxResults", "3")
                .queryString("key", myApiKey)
                .asString();
        return response.getBody();
    }







}