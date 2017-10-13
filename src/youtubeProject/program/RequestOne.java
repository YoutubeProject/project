package youtubeProject.program;

import youtubeProject.channels.ChannelListResponse;
import youtubeProject.channels.OneChannel;
import youtubeProject.channels.Request1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.scene.text.Text;
import youtubeProject.interfase.userInterfase.settingsInterfase.SaveToCache;

import java.util.Scanner;


import java.io.*;

import static youtubeProject.program.Settings.*;

public class RequestOne {
    Text name;
    Text description;
    public static String channelId = "UCJALCpMORvQrlN7dAPLiCWg";

    public RequestOne(String channelId ){
        this.channelId = channelId;
    }
    public RequestOne(){
        this.channelId = channelId;
    }




    Channel getChannel() {
        try {
            if (SaveToCache.useCache) {
                System.out.println("Use cache option was checked and is 'true'.");
                if (checkIfCached(channelId)) {
                    System.out.println("Channel was checked if cached and is 'true'.");
                    System.out.println("Channel was converted from read cached data.");
                    return new Channel(convertStringToChannel(readFileToString(channelId)));
                }else {
                    System.out.println("Channel was checked if cached and is 'false'.");
                    String jsonString = Request1.getChannelDataAsString(channelId);
                    System.out.println("Channel data was requested from server and converted to Json string.");
                    writeCacheToFile(jsonString,channelId);
                    System.out.println("Json string was converted to object.\nFinish.\n");
                    return new Channel(convertStringToChannel(jsonString));
                }
            }else {
                return new Channel(Request1.getYouTubeChannelAsObject(channelId));
            }
        }catch (UnirestException e) {
            //alert("UnirestException thrown","Cannot get channel.");
        }
        return null;
    }

    void writeCacheToFile(String jsonString, String channelId) {
        try {
            String savePath = Settings.cacheDirectory + channelId + ".txt";
            File file = new File(savePath);
            FileWriter writer = new FileWriter(file);
            writer.write(jsonString);
            writer.flush();
            System.out.println("Channel has been successfully cached.");
        } catch (Exception e){
           //alert("Exception thrown","Channel not cashed.");
        }
    }

    boolean checkIfCached(String channelId) {
        String channelIdFullName = channelId + ".txt";
        File cashDirectoryFile = new File(Settings.cacheDirectory);
        File[] allFiles = cashDirectoryFile.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (channelIdFullName.equals(file.getName())) return true;
            }
        }
        return false;
    }

    static String readFileToString(String channelName) {
        String cachedChannelPath = (Settings.cacheDirectory + "/" + channelName + ".txt");
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

    OneChannel convertStringToChannel(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        ChannelListResponse channelsResponse = null;
        try {
            channelsResponse = objectMapper.readValue(jsonString, ChannelListResponse.class);
        } catch (IOException e) {
            //alert("IOException thrown","Cannot convert a Json string to an object.");
        }
        return channelsResponse.items.get(0);
    }

    //void generateRequest1() {
        //name.setText(nameRequest1);
        //description.setText("Shows global information about a channel.");
    //}

    //void generateRequest4() {
        //name.setText(nameRequest4);
        //description.setText("Shows information (including total number of comments) about a channel.");
    //}

}
