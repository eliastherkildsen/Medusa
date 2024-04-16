package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;
import org.apollo.template.model.Snake;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {

    @FXML
    private Label labelGameOver, labelScore;

    private Snake snake = new Snake();

    private SettingsController settingsController = SettingsController.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        settingsController.setMusicRate(0.2);
        updateScore();
    }


    private void updateScore() {
        labelScore.setText(String.format("SCORE: %d",snake.getPoint()));
    }


    public void onScoreBoard(){
        MainController.getInstance().changeView(ViewList.SCOREBOARD, BorderPaneRegion.CENTER);
    }

    public void onMainMenu(){
        settingsController.setMusicRate(1.0);
        MainController.getInstance().changeView(ViewList.MENU,BorderPaneRegion.CENTER);
    }


}
