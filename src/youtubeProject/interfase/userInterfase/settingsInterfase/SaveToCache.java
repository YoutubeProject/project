package youtubeProject.interfase.userInterfase.settingsInterfase;

import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.program.Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 1 on 03.10.2017.
 */
public class SaveToCache {
    private static Scanner sc = new Scanner(System.in);
    private static Settings settings = new Settings();
    public static boolean saveCache;

    public static void save() throws IOException, UnirestException {
        boolean x = true;
        do{
            System.out.println("Save the cache?");
            String s = sc.nextLine();
            if(s.equals("TRUE")||s.equals("True")||s.equals("true")){
                settings.downloadSavedSettings();
                saveCache = true;
            }else {
                saveCache = false;
                x = false;
            }
        }while (x);
    }


}
