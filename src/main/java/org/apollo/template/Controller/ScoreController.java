package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

import java.net.URL;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {

    @FXML
    private Label   labelFirstName, labelSecName, labelThirdName, labelFourthName, labelFiftName,
                    labelFirstScore, labelSecScore, labelthirdScore, labelFourthScore, labelfiftScore;

    //private String[][] topFiveScores = new String[5][2];

    private String[][] topFiveScores = {{"Elias" , "123"}, {"Mads", "122"}, {"Kamilla","121"}, {"Henrik","120"}, {"Carl","119"}};

    public static ScoreController instance;
    private ScoreController(){    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        fillScoreBoard();
    }
    

    private void fillScoreBoard() {

        labelFirstName.setText(String.format("%s", topFiveScores[0][0]));
        labelFirstScore.setText(String.format("SCORE: %s", topFiveScores[0][1]));

        labelSecName.setText(String.format("%s", topFiveScores[1][0]));
        labelSecScore.setText(String.format("SCORE: %s", topFiveScores[1][1]));

        labelThirdName.setText(String.format("%s", topFiveScores[2][0]));
        labelthirdScore.setText(String.format("SCORE: %s", topFiveScores[2][1]));

        labelFourthName.setText(String.format("%s", topFiveScores[3][0]));
        labelFourthScore.setText(String.format("SCORE: %s", topFiveScores[3][1]));

        labelFiftName.setText(String.format("%s", topFiveScores[4][0]));
        labelfiftScore.setText(String.format("SCORE: %s", topFiveScores[4][1]));

    }


    public void onMainMenu(){

        // resets the array
        topFiveScores = null;
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    public static ScoreController getInstance() {
        if (instance == null){
            instance = new ScoreController();
        }

        return instance;
    }


}

    
