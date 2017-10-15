package youtubeProject.program;


import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.channels.Request1;
import youtubeProject.interfase.userInterfase.settingsInterfase.SaveToCache;
import youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase.YouTubeAnalytics;

import java.io.*;
import java.util.ArrayList;


public class Settings  {
    public static String cacheDirectory = "Cache/" + YouTubeAnalytics.channelId + ".txt";
    public static boolean showExecutionTime;


    public static ArrayList<String>list = new ArrayList<>();

    public void writeToFile() throws UnirestException, IOException {
       String s = Request1.getChannelDataAsString(YouTubeAnalytics.channelId);
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (YouTubeAnalytics.channelId.equals(list.get(i))) {
                    return;
                }
            }
        }
        else if(list.isEmpty()){
            list.add(YouTubeAnalytics.channelId);
            Program.writeCacheToFile(s,YouTubeAnalytics.channelId);
            return;
        }else {
            list.add(YouTubeAnalytics.channelId);
            Program.writeCacheToFile(s,YouTubeAnalytics.channelId);
        }
    }


    void cleanFilesInCacheDirectory() {
        File folder = new File(cacheDirectory);
        for (File file : folder.listFiles()) file.delete();
    }


}
