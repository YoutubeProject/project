package youtubeProject.interfase.userInterfase;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import youtubeProject.interfase.userInterfase.settingsInterfase.ProgramSettings;
import youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase.YouTubeAnalytics;

import java.util.Scanner;



public class GeneralScreen {
    private YouTubeAnalytics youTubeAnalytics;
    private ProgramSettings programSettings;

    protected Scanner sc = new Scanner(System.in);



    public void mainScreen(){
        System.out.println("Welcome to YouTube Analytics");
        System.out.println("       version 1.0");
        System.out.println();

    }
    public void enterKey(){
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