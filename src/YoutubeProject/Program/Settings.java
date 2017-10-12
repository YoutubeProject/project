package YoutubeProject.Program;


import java.io.*;


public class Settings  {

    static boolean useCache;
    boolean showExecutionTime;
    String savedSettingsPath;
    static String cacheDirectory;

    public Settings() {
        //savedSettingsPath = "/Users/test/IdeaProjects/GoIT_JavaCore/Final Project/settings.txt";
        //downloadSavedSettings();
    }

    void downloadSavedSettings() {
        try (BufferedReader br = new BufferedReader(new FileReader(savedSettingsPath))) {
            useCache = br.readLine().equals("true");
            cacheDirectory = br.readLine();
            showExecutionTime = br.readLine().equals("true");
        } catch (IOException e) {
            //alert("IOException thrown","Cannot download from file saved settings.");
        }
    }

    void saveSettings() {
        try {
            File file = new File(savedSettingsPath);
            FileWriter writer = new FileWriter(file);
            writer.write((useCache ? "true" : "false") + "\n");
            writer.write(cacheDirectory + "\n");
            writer.write(showExecutionTime ? "true" : "false");
            writer.flush();
        } catch (Exception e){
           // alert("Exception thrown","Settings file not found.");
        }
    }

    void cleanFilesInCacheDirectory() {
        File folder = new File(cacheDirectory);
        for (File file : folder.listFiles()) file.delete();
    }

}
