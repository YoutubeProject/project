package youtubeProject.channels;

import youtubeProject.data.Request2;
import youtubeProject.data.SearchListResponse;
import youtubeProject.data.SearchResult;
import youtubeProject.videos.Request3;
import youtubeProject.videos.VideoListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;

import static youtubeProject.program.RequestOne.channelId;

public class Request1 {

    public static String myApiKey = "AIzaSyBifuUatBiNP7C8X2zjMM1BJWinnrES6Ic";

    public static OneChannel getYouTubeChannelAsObject(String channelId) throws UnirestException {
        ChannelListResponse channelsResponse = requestChannelDataAsObject(channelId);
        return channelsResponse.items.get(0);
    }
    public static ChannelListResponse getYouTubeChannelResponseAsObject(String channelId) throws UnirestException {
        return requestChannelDataAsObject(channelId);
    }

    public static String getChannelDataAsString(String channelId) throws UnirestException {
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
        HttpResponse<ChannelListResponse> response = Unirest.get("https://www.googleapis.com/youtube/v3/channels")
                .queryString("id", channelId)
                .queryString("part", "snippet,statistics")
                .queryString("fields", "items(snippet(title,publishedAt),statistics(viewCount,subscriberCount,videoCount))")
                .queryString("key", "AIzaSyDU2cowjo-PZ6Kmj93yjSU3grbjNL20LD0")
                .asObject(ChannelListResponse.class);
        return response.getBody();
    }

    private static String requestChannelDataAsString(String channelId) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/channels")
                .queryString("id", channelId)
                .queryString("part", "snippet,statistics")
                .queryString("fields", "items(snippet(title,publishedAt),statistics(viewCount,subscriberCount,videoCount))")
                .queryString("maxResults", "3")
                .queryString("key", "AIzaSyDU2cowjo-PZ6Kmj93yjSU3grbjNL20LD0")
                .asString();
        return response.getBody();
    }








}