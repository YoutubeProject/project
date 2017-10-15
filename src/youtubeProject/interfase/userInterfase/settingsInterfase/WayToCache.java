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
   public static String way = "Cache/";

    private static ArrayList<String> list = new ArrayList<>();



    public static void display() throws IOException, UnirestException {
        System.out.println("Way to cache");
        System.out.println();
        System.out.println("Current way : " + way );
        System.out.println("Enter new way to the cache");
        way = sc.nextLine();
    }

}
