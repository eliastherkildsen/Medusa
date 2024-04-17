package org.apollo.template.Controller;

import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

public class ScoreController {
    public static ScoreController instance;

    private ScoreController(){

    }


    public void onMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    public static ScoreController getInstance() {
        if (instance == null){
            instance = new ScoreController();
        }

        return instance;
    }
}
