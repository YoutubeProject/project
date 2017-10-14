package youtubeProject.interfasefxml;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.event.TreeModelEvent;

public class Main extends Application {

        public static TreeModelEvent pane;
    public static Object youTubeAnalytics;

    @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("../interfasefxml/projectform.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);

        }

    }

