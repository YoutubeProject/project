
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
    static String channelId;



    public static void main(String[] args) throws UnirestException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input Channel ID   ");
        channelId = in.nextLine();
        //readFileToString(channelId);

        String jsonString = Request1.getChannelDataAsString(channelId);
        System.out.println("Channel data was requested from server and converted to Json string.");
        try {
            writeCacheToFile(jsonString, channelId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Json string was converted to object.\nFinish.\n");
        readFileToString(channelId);
        ChannelListResponse channelListResponse1 = convertStringToChannel(jsonString);
        ArrayList<OneChannel>list1 = (ArrayList<OneChannel>) channelListResponse1.items;
        for(int i = 0; i < channelListResponse1.items.size(); i++){
            System.out.println(channelListResponse1.items.get(i).snippet.publishedAt);
        }


        //return new Channel(convertStringToChannel(jsonString));



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

