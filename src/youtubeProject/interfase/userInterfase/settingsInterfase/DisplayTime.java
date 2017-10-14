package userInterfase.settingsInterfase;

import java.util.Scanner;

/**
 * Created by 1 on 11.10.2017.
 */
public class DisplayTime {
    private static Scanner sc = new Scanner(System.in);

    public static void display() {
        boolean x = true;
        do{
            System.out.println("Display the time spent on the task?");
            String s = sc.nextLine();
            if(s.equals("TRUE")||s.equals("True")||s.equals("true")){

                x = false;
            }else {

                x = false;
            }
        }while (x);

    }
}
