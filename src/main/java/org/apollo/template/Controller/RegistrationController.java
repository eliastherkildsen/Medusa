package org.apollo.template.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private StackPane registrationStackPane;
    @FXML
    private Button btnStartGame, btnCancel;
    @FXML
    private TextField txfPlayerName;


    public static String playerName = "Player 1";



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        registrationStackPane.setFocusTraversable(true);

        loadListener();
    }



    private void loadListener() {

        registrationStackPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode().equals(KeyCode.ENTER)){

                    getPlayerName();
                    MainController.getInstance().changeView(ViewList.GAME, BorderPaneRegion.CENTER);
                }
            }
        });
    }




    public void onStartGame(){
        getPlayerName();
        MainController.getInstance().changeView(ViewList.GAME, BorderPaneRegion.CENTER);
    }

    public void onCancel(){
        txfPlayerName.clear();
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    private void getPlayerName() {
        playerName = txfPlayerName.getText();
    }

}
