package org.apollo.template.Controller;

import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

public class SettingsController {


    public void onMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }
}
