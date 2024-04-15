package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

public class GameOverController {

    @FXML
    private Label labelGameOver;

    public void onScoreBoard(){
        MainController.getInstance().changeView(ViewList.SCOREBOARD, BorderPaneRegion.CENTER);
    }

    public void onMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU,BorderPaneRegion.CENTER);
    }

}
