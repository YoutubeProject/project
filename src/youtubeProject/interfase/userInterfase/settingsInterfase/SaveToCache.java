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
    public static boolean saveCache = true;

    public static void save() throws IOException, UnirestException {
        boolean x = true;
        do{
            System.out.println("Save the cache?(true/false)");
            String s = sc.nextLine();
            if(s.equals("TRUE")||s.equals("True")||s.equals("true")){
                saveCache = true;
                x = false;
            }else {
                saveCache = false;
                x = false;
            }
        }while (x);
    }


}
