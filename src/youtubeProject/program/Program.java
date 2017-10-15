
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.channels.ChannelListResponse;
import youtubeProject.channels.OneChannel;
import youtubeProject.channels.Request1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Created by 1 on 03.10.2017.
 */
public class Program {
    Scanner in = new Scanner(System.in);
static ChannelListResponse channelListResponse;
    static String channelId1;
    static String channelId2;



    public static void main(String[] args) throws UnirestException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input Channel ID   ");
        channelId1 = in.nextLine();
        channelId2 = in.nextLine();
        //readFileToString(channelId);

        String jsonString = Request1.getChannelDataAsString(channelId1);
        System.out.println("Channel data was requested from server and converted to Json string.");
        try {
            writeCacheToFile(jsonString, channelId1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Json string was converted to object.\nFinish.\n");
        setChennelIds(channelId1,channelId2);


        //return new Channel(convertStringToChannel(jsonString));



    }

    private static void setChennelIds(String channelId1, String channelId2) throws UnirestException, IOException {
        String jsonString1 = Request1.getChannelDataAsString(channelId1);
        String jsonString2 = Request1.getChannelDataAsString(channelId2);
        writeCacheToFile(jsonString1,channelId1);
        writeCacheToFile(jsonString2,channelId2);
        ChannelListResponse channelListResponse1 = convertStringToChannel(jsonString1);
        ChannelListResponse channelListResponse2 = convertStringToChannel(jsonString2);
        try {
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
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }




    private static void writeCacheToFile(String jsonString, String channelId) throws IOException {
        String savePath = "Cache/" + channelId + ".txt";
        File file = new File(savePath);
        FileWriter writer = new FileWriter(file);
        writer.write(jsonString);
        writer.flush();
        System.out.println("File creat");
    }

    static String readFileToString(String channelName) {
        String cachedChannelPath = ("Cache/" + channelName + ".txt");
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

}

