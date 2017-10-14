package youtubeProject.interfasefxml;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button youTubeAnalyticsButton;

//    @FXML
//    public void onClickMethod(){
//        youTubeAnalyticsButton.setFocusTraversable(false);
//        youTubeAnalyticsButton.setOnAction(event -> {
//            Main.pane.getChildren().clear();
//            Main.pane.getChildren().add(Main.youTubeAnalytics.screen);
//        });
//    }

    public void showDialog(ActionEvent actionEvent){

        try{
            final boolean[] answer = new boolean[1];
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../interfasefxml/closeProgramWindow.fxml"));
            stage.setTitle("Close program");
            stage.setMinWidth(300);
            stage.setMinHeight(150);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        }catch (IOException e) {
            e.printStackTrace();

        }

    }

}

