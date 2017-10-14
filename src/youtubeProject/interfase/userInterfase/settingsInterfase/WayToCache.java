package youtubeProject.interfase.userInterfase.settingsInterfase;

import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.channels.Request1;
import youtubeProject.program.RequestOne;
import youtubeProject.program.Settings;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 1 on 11.10.2017.
 */
public class WayToCache {
   private static Scanner sc = new Scanner(System.in);
   private static String way = "/Cache/" + RequestOne.channelId;

    private static ArrayList<String> list = new ArrayList<>();

   public WayToCache(String way){
       this.way = way;
   }

    public static void display() throws IOException, UnirestException {
        System.out.println("Way to cache");
        System.out.println(Settings.cacheDirectory);
        System.out.println("Current way :" + way );
        System.out.println("Enter new way to the cache");
        way = sc.nextLine();
        newWayToCache(way);
    }
    private static void newWayToCache(String way) throws UnirestException, IOException {
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
            FileWriter writer = new FileWriter(way + RequestOne.channelId + ".txt");
            return;
        }else {
            list.add(RequestOne.channelId);
            FileWriter writer = new FileWriter(way + RequestOne.channelId + ".txt");
        }
    }
}
