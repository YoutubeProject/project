package youtubeProject.interfase.userInterfase.settingsInterfase;


import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.interfase.userInterfase.GeneralScreen;
import youtubeProject.program.Program;

import java.io.IOException;
import java.util.Scanner;

public class ProgramSettings {
    static Scanner sc = new Scanner(System.in);

    public ProgramSettings() throws IOException, UnirestException {
        addTask();
    }

    public static void displayTask() {
        System.out.println("Settings \n");
        System.out.println("Choose task:\n " +
                           "1.Return to the main screen \n " +
                           "2.Change/Use the cahe \n " +
                           "3.Change way to the cache \n " +
                           "4.Change the display of the time spent executing \n " +
                           "5.Clear the cache");
    }
    public static int chooseTask(){
        int result;
        boolean x = true;
        do{
            displayTask();
            String enter = sc.nextLine();
            result = Integer.parseInt(enter);
            if(result >= 1&&result <= 5){
                return result;
            }else {
                System.out.println("Invalid number \n Try again ");
            }
        }while (x);
        return Integer.parseInt(null);
    }
    public static void addTask() throws IOException, UnirestException {
        do{
        int x = chooseTask();
        String continu;
        switch (x){
            case 1:GeneralScreen.enterKey();
                break;
            case 2:
                SaveToCache.save();
                break;
            case 3:
                WayToCache.display();
                break;
            case 4://метод который отображает время затраченное на выполнение задачи
                break;
            case 5:
                Program.deleteAllFilesFolder();//метод который отображает время затраченное на выполнение задачи
                break;
        }
        System.out.println("Do you want to continue Y/N");
        continu = sc.nextLine();
        if(continu.equals("Y")||continu.equals("y")){
        }else if(continu.equals("N")||continu.equals("n")){
            break;
        }
    }while (true);
    }

}