package youtubeProject.interfase.userInterfase.youtubeAnaliticsInterfase;


import youtubeProject.interfase.userInterfase.settingsInterfase.ProgramSettings;

public class YouTubeAnalytics extends ProgramSettings {

    public YouTubeAnalytics() {
        addTask();
    }

    @Override
    public void displayTask() {
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

    @Override
    public int chooseTask() {
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

    @Override
    public void addTask() {
        boolean b = true;
        do {
            int x = chooseTask();
            String channelID;
            String continu;
            switch (x) {
                case 1:
                    enterKey();
                    break;
                case 2:
                    System.out.println("Enter the channel");
                    channelID = sc.nextLine();
                    //медод который отображает глобальную информацию о канале
                    break;
                case 3:
                    String[] channels = enterChannels();
                    //здесь твой медод примет 1 и 2 элементы массива и сравнивает глобальную информацию о каналах
                    break;
                case 4://метод сортировки каналов по их данным(принимает массив ID)
                    break;
                case 5:
                    System.out.println("Enter the channel");
                    channelID = sc.nextLine();
                    //медиа резонанс
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
                b = true;
            }else if(continu.equals("N")||continu.equals("n")){
                b = false;
            }
        }while (b);
    }

    public String[]enterChannels(){
        String array[] = new String[2];
        System.out.println("Enter two channels ID in space");
        String enter = sc.nextLine();
        array = enter.split("");
        return array;
    }

}