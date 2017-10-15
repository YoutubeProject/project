package youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase;
import youtubeProject.interfase.userInterfase.GeneralScreen;
import youtubeProject.program.Program;



import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.interfase.userInterfase.settingsInterfase.ProgramSettings;
import youtubeProject.videos.Request3;

import java.io.IOException;
import java.util.Scanner;

public class YouTubeAnalytics {
    public static String channelId;
    static Scanner sc = new Scanner(System.in);


    public YouTubeAnalytics() throws IOException, UnirestException {
        addTask();
    }


    public static void displayTask() {
        System.out.println("YouTube Analytics \n");
        System.out.println("Choose task: \n" +
                "1.Return to the main screen\n" +
                "2.Display global information about the channel \n" +
                "3.Compare global information about channels \n" +
                "4.Sort channels by their date \n" +
                "5.Media Resonance \n" +
                "6.Compare Media Resonance \n" +
                "7.Sort by Media Resonance");
    }


    public static int chooseTask() {
        int result;
        boolean x = true;
        do{
            displayTask();
            String enter = sc.nextLine();
            result = Integer.parseInt(enter);
            if(result >= 1&&result <= 6){
                return result;
            }else {
                System.out.println("Invalid number + \n + Try again ");
            }
        }while (x);
        return Integer.parseInt(null);
    }


    public static void addTask() throws IOException, UnirestException {
        do {
            String continu;
            switch (chooseTask()) {
                case 1:
                    GeneralScreen.enterKey();
                    break;
                case 2:
                    System.out.println("Enter the channel");
                    channelId = sc.nextLine();
                    Program.setChennelId(channelId);
                    break;
                case 3:
                    String[] channels = enterChannels();
                    Program.setChennelIds(channels[0],channels[1]);
                    break;
                case 4://метод сортировки каналов по их данным(принимает массив ID)
                    break;
                case 5:
                    System.out.println("Enter the channel");
                    channelId = sc.nextLine();
                    Request3.setChennelId(channelId);
                    break;
                case 6:
                    String[] channels1 = enterChannels();
                    //метод сравнения медиа резонансов 2-х каналов
                    break;
                case 7://метод сортировки по медиараезонансу(принимает массив ID)
                    break;
            }
            System.out.println("Do you want to continue Y/N");
            continu = sc.nextLine();
            if(continu.equals("Y")||continu.equals("y")){
            }else if(continu.equals("N")||continu.equals("n")){
                break;
            }else break;
        }while (true);
    }

    public static String[]enterChannels(){
        String array[] = new String[2];
        System.out.println("Enter two channels ID in space");
        String enter = sc.nextLine();
        array = enter.split(" ");
        return array;
    }

}