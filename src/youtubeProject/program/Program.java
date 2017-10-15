package youtubeProject.program;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.channels.ChannelListResponse;
import youtubeProject.channels.OneChannel;
import youtubeProject.channels.Request1;
import youtubeProject.interfase.userInterfase.settingsInterfase.SaveToCache;
import youtubeProject.interfase.userInterfase.settingsInterfase.WayToCache;
import youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase.YouTubeAnalytics;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by 1 on 03.10.2017.
 */
public class Program {
    static ArrayList<String>list = new ArrayList<>();



    public static void setChennelIds(String channelId1, String channelId2) throws UnirestException, IOException {
        String jsonString1;
        String jsonString2;
        if(SaveToCache.saveCache){
            jsonString1 = jsonFromCacheOrRequest(channelId1);
            jsonString2 = jsonFromCacheOrRequest(channelId2);
            writeCacheToFile(jsonString1,channelId1);
            writeCacheToFile(jsonString2,channelId2);
            ChannelListResponse channelListResponse1 = convertStringToChannel(jsonString1);
            ChannelListResponse channelListResponse2 = convertStringToChannel(jsonString2);
            showInfoRequest(channelListResponse1,channelListResponse2);
        }else {
            jsonString1 = jsonFromCacheOrRequest(channelId1);
            jsonString2 = jsonFromCacheOrRequest(channelId2);
            ChannelListResponse channelListResponse1 = convertStringToChannel(jsonString1);
            ChannelListResponse channelListResponse2 = convertStringToChannel(jsonString2);
            showInfoRequest(channelListResponse1,channelListResponse2);
        }
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

    public static void showInfoRequest(ChannelListResponse channelListResponse){
            for (int i = 0; i < 1; i++) {
                System.out.println(" Имя канала  - " + channelListResponse.items.get(i).snippet.title + "\n" +
                        " Дата создания канала  - " + channelListResponse.items.get(i).snippet.publishedAt + "\n" +
                        " Количество подписчиков канала  - " + channelListResponse.items.get(i).statistics.subscriberCount + "\n" +
                        " Количество видео канала  - " + channelListResponse.items.get(i).statistics.videoCount + "\n" +
                        " Кол-во просмотров всех видео канала  - " + channelListResponse.items.get(i).statistics.viewCount + "\n");
            }
    }
    public static void showInfoRequest(ChannelListResponse channelListResponse1, ChannelListResponse channelListResponse2){
        for (int i = 0; i < 1; i++) {
            System.out.println(" Имя канала 1 - " + channelListResponse1.items.get(i).snippet.title + "\n" +
                    " Имя канала 2 - " + channelListResponse2.items.get(i).snippet.title + "\n" +
                    " Дата создания канала 1 - " + channelListResponse1.items.get(i).snippet.publishedAt + "\n" +
                    " Дата создания канала 2 - " + channelListResponse2.items.get(i).snippet.publishedAt + "\n" +
                    " Количество подписчиков канала 1 - " + channelListResponse1.items.get(i).statistics.subscriberCount + "\n" +
                    " Количество подписчиков канала 2 - " + channelListResponse2.items.get(i).statistics.subscriberCount + "\n" +
                    " Количество видео канала 1 - " + channelListResponse1.items.get(i).statistics.videoCount + "\n" +
                    " Количество видео канала 2 - " + channelListResponse2.items.get(i).statistics.videoCount + "\n" +
                    " Кол-во просмотров всех видео канала 1 - " + channelListResponse1.items.get(i).statistics.viewCount + "\n" +
                    " Кол-во просмотров всех видео канала 2 - " + channelListResponse2.items.get(i).statistics.viewCount);
        }
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
            return Request1.getChannelDataAsString(channelId);
        }
        return null;
    }

    public static void writeCacheToFile(String jsonString, String channelId) throws IOException {
        String savePath = WayToCache.way + channelId + "info.txt";
        File file = new File(savePath);
        FileWriter writer = new FileWriter(file);
        writer.write(jsonString);
        writer.flush();
        writer.close();
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
    public static void deleteAllFilesFolder() {
        for (File file: new File(WayToCache.way).listFiles())
            if (file.isFile()) file.delete();
        list.clear();
    }

}

