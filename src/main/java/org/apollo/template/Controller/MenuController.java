package org.apollo.template.Controller;

import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

public class MenuController {

    public void onNewGame(){
        MainController.getInstance().changeView(ViewList.GAME, BorderPaneRegion.CENTER);
    }



}
