package youtubeProject.interfase.userInterfase.settingsInterfase;


import com.mashape.unirest.http.exceptions.UnirestException;
import youtubeProject.interfase.userInterfase.GeneralScreen;

import java.io.IOException;

public class ProgramSettings extends GeneralScreen {

    public ProgramSettings() throws IOException, UnirestException {
        addTask();
    }

    public void displayTask() {
        System.out.println("Settings \n");
        System.out.println("Choose task:\n " +
                           "1.Return to the main screen \n " +
                           "2.Change/Use the cahe \n " +
                           "3.Change way to the cache \n " +
                           "4.Change the display of the time spent executing");
    }
    public int chooseTask(){
        int result;
        boolean x = true;
        do{
            displayTask();
            String enter = sc.nextLine();
            result = Integer.parseInt(enter);
            if(result >= 1&&result <= 4){
                return result;
            }else {
                System.out.println("Invalid number \n Try again ");
            }
        }while (x);
        return Integer.parseInt(null);
    }
    public void addTask() throws IOException, UnirestException {
        boolean b = true;
        do{
        int x = chooseTask();
        String continu;
        switch (x){
            case 1:enterKey();
                break;
            case 2:
                SaveToCache.save();
                break;
            case 3:
                WayToCache.display();
                break;
            case 4://метод который отображает время затраченное на выполнение задачи
                break;
        }
        System.out.println("Do you want to continue Y/N");
        continu = sc.nextLine();
        if(continu.equals("Y")||continu.equals("y")){
            b = true;
        }else if(continu.equals("N")||continu.equals("n")){
            b = false;
        }
    }while (b);
    }

}