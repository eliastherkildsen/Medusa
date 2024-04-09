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


    public static String playerName;


    /**
     * Method for initializing the controller by setting focus traversal and loading key press event listeners.
     *
     * @param url the location for resolving paths, or null if unknown.
     * @param resourceBundle the resource bundle for this controller, or null if none.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // resets player name to default name "Player 1"
        playerName = "Player 1";

        registrationStackPane.setFocusTraversable(true);
        loadListener();
    }


    /**
     * Method for setting up a key press event listener for handling the "Enter" key press event.
     * If the "Enter" key is pressed, it triggers a method to get the player's name and changes the view to the game view.
     */
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


    /**
     * Method for starting the game
     */
    public void onStartGame(){
        getPlayerName();
        MainController.getInstance().changeView(ViewList.GAME, BorderPaneRegion.CENTER);
    }


    /**
     * Method for cancelling a new game and navigate to the main menu
     */
    public void onCancel(){
        txfPlayerName.clear();
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    /**
     * Method for getting the entered player name
     */
    private void getPlayerName() {
        playerName = txfPlayerName.getText();
    }

}
