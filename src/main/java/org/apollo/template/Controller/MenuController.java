package org.apollo.template.Controller;

import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

public class MenuController {

    public void onNewGame(){
        MainController.getInstance().changeView(ViewList.REGISTRATION, BorderPaneRegion.CENTER);
    }

    public void onScoreboard(){
        MainController.getInstance().changeView(ViewList.SCOREBOARD, BorderPaneRegion.CENTER);
    }

    public void onSettings() {MainController.getInstance().changeView(ViewList.SETTINGS, BorderPaneRegion.CENTER);}

}
