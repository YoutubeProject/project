package youtubeProject.interfase.userInterfase;


import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.interfase.userInterfase.settingsInterfase.ProgramSettings;
import youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase.YouTubeAnalytics;

import java.io.IOException;
import java.util.Scanner;



public class GeneralScreen {
    private static YouTubeAnalytics youTubeAnalytics;
    private static ProgramSettings programSettings;

    static Scanner sc = new Scanner(System.in);



    public void mainScreen(){
        System.out.println("Welcome to YouTube Analytics");
        System.out.println("       version 1.0");
        System.out.println();

    }
    public static void enterKey() throws IOException, UnirestException {
        boolean x = true;
        do {
            System.out.println("Choose your choise: \n " +
                    "1. Go to the YouTube Analytics \n " +
                    "2. Go to the Settings");
            String enter = sc.nextLine();
            int i = Integer.parseInt(enter);
            if (i == 1) {
               youTubeAnalytics = new YouTubeAnalytics();
                x = false;
            } else if (i == 2){
                programSettings = new ProgramSettings();
                x = false;
            }
            else {
                System.out.println("Invalid number + \n + Try again ");
            }
        }while (x);
    }


}