package youtubeProject.videos;



import com.fasterxml.jackson.databind.ObjectMapper;
import youtubeProject.channels.ChannelListResponse;
import youtubeProject.channels.Request1;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.interfase.userInterfase.settingsInterfase.SaveToCache;
import youtubeProject.interfase.userInterfase.settingsInterfase.WayToCache;
import youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase.YouTubeAnalytics;

import java.io.*;
import java.util.ArrayList;

public class Request3{
        static ArrayList<String> list = new ArrayList<>();

    public static String requestVideoDataAsString(String videosList, String apiKey) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://www.googleapis.com/youtube/v3/videos")
                .queryString("id", videosList)
                .queryString("part", "statistics")
                .queryString("fields", "statistics(commentCount))")
                .queryString("key", apiKey)
                .asString();
        return response.getBody();
    }
    public static void setChennelId(String channelId) throws UnirestException, IOException {
        String jsonString;
        if(SaveToCache.saveCache) {
            jsonString = jsonFromCacheOrRequest(channelId);
            writeCacheToFile(jsonString, channelId);
            ChannelListResponse channelListResponse = convertStringToChannel(jsonString);
            showInfoRequest(channelListResponse);
        }else {
            jsonString = jsonFromCacheOrRequest(channelId);
            ChannelListResponse channelListResponse = convertStringToChannel(jsonString);
            showInfoRequest(channelListResponse);
        }
    }
    public static void writeCacheToFile(String jsonString, String channelId) throws IOException {
        String savePath = WayToCache.way + channelId + ".txt";
        File file = new File(savePath);
        FileWriter writer = new FileWriter(file);
        writer.write(jsonString);
        writer.flush();
        writer.close();
    }
    public static void showInfoRequest(ChannelListResponse channelListResponse){
        for (int i = 0; i < 1; i++) {
            System.out.println(" Имя канала  - " + channelListResponse.items.get(i).snippet.title + "\n" +
                    " Дата создания канала  - " + channelListResponse.items.get(i).snippet.publishedAt + "\n" +
                    " Количество подписчиков канала  - " + channelListResponse.items.get(i).statistics.subscriberCount + "\n" +
                    " Количество видео канала  - " + channelListResponse.items.get(i).statistics.videoCount + "\n" +
                    " Количество просмотров всех видео канала  - " + channelListResponse.items.get(i).statistics.viewCount + "\n" +
                    " Количество комментариев - " + channelListResponse.items.get(i).statistics.commentCount);
        }
    }
    static ChannelListResponse convertStringToChannel(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        ChannelListResponse channelsResponse = null;
        try {
            channelsResponse = objectMapper.readValue(jsonString, ChannelListResponse.class);
        } catch (IOException e) {
            //alert("IOException thrown","Cannot convert a Json string to an object.");
        }
        return channelsResponse;
    }
    public static String jsonFromCacheOrRequest(String channelId) throws UnirestException {
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (channelId.equals(list.get(i))) {
                    return readFileToString(channelId);
                }
            }
        }
        else if(list.isEmpty()){
            list.add(channelId);
            return Request1.getChannelDataAsString(channelId);
        }else {
            list.add(YouTubeAnalytics.channelId);
            return requestVideoDataAsString(channelId,Request1.myApiKey);
        }
        return null;
    }
    static String readFileToString(String channelName) {
        String cachedChannelPath = (WayToCache.way + channelName + "info.txt");
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(cachedChannelPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            //alert("IOException thrown","Cannot read cached file.");
        }
        return result.toString();
    }

}