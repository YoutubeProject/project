package youtubeProject.program;


import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.channels.Request1;
import youtubeProject.interfase.userInterfase.settingsInterfase.SaveToCache;

import java.io.*;
import java.util.ArrayList;


public class Settings  {
    public static String cacheDirectory = "/Cache/" + RequestOne.channelId + ".txt";
    public static String savedSettingsPath = "/Settings/settings.txt";
    public static boolean showExecutionTime;


    ArrayList<String>list = new ArrayList<>();

    public void downloadSavedSettings() throws UnirestException, IOException {
        String s = Request1.getChannelDataAsString(RequestOne.channelId);
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (RequestOne.channelId.equals(list.get(i))) {
                    return;
                }
            }
        }
        else if(list.isEmpty()){
            list.add(RequestOne.channelId);
            FileWriter writer = new FileWriter("/Cache/" + RequestOne.channelId + ".txt");
            return;
        }else {
            list.add(RequestOne.channelId);
            FileWriter writer = new FileWriter("/Cache/" + RequestOne.channelId + ".txt");
        }
    }


    void cleanFilesInCacheDirectory() {
        File folder = new File(cacheDirectory);
        for (File file : folder.listFiles()) file.delete();
    }


}
