import youtubeProject.interfase.userInterfase.GeneralScreen;

import java.util.Scanner;

/**
 * Created by 1 on 03.10.2017.
 */
public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        GeneralScreen generalScreen = new GeneralScreen();
        generalScreen.mainScreen();
        generalScreen.enterKey();
    }

}
