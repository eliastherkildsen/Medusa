package org.apollo.template.Controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.apollo.template.DirectionState.*;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;
import org.apollo.template.model.Snake;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {


    @FXML
    private StackPane gameStackPane;
    @FXML
    private ImageView gameView;
    @FXML
    private Canvas snakeCanvas, eatableCanvas;
    @FXML
    private Label scoreLabel, pausedGameLabel;
    @FXML
    private VBox vBoxPausedGame;
    @FXML
    private Button btnResume, btnMainMenu, btnExit;

    private boolean escSwitchStage = false;


    Snake snake = new Snake();
    


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setStartDirection();
        visibility();
        gameStackPane.setFocusTraversable(true);

        loadListener();
    }



    /**
     * Method for handling key press events to change the direction of the snake.
     * If a key is pressed corresponding to one of the four direction keys (UP, DOWN, LEFT, RIGHT), the snake's
     * direction is updated accordingly.
     * If the ESC key is pressed, the game is paused.
     *
     * @param keyEvent a KeyEvent object containing information about the key press event that triggered the action
     */
    private void loadListener() {
        gameStackPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode().equals(KeyCode.ESCAPE)){

                    if (!escSwitchStage) {
                        System.out.println("YEAH!");
                        vBoxPausedGame.setVisible(true);
                    }

                    if (escSwitchStage){
                        System.out.println("NEARHH!");

                        vBoxPausedGame.setVisible(false);
                    }

                    toggleEscState();

                }


                if (keyEvent.getCode().equals(KeyCode.UP)){
                    System.out.println("UP");
                    snake.moveSnake(keyEvent.getCode());
                }
                if (keyEvent.getCode().equals(KeyCode.DOWN)){
                    System.out.println("DOWN");
                    snake.moveSnake(keyEvent.getCode());
                }
                if (keyEvent.getCode().equals(KeyCode.LEFT)){
                    System.out.println("LEFT");
                    snake.moveSnake(keyEvent.getCode());
                }
                if (keyEvent.getCode().equals(KeyCode.RIGHT)){
                    System.out.println("RIGHT");
                    snake.moveSnake(keyEvent.getCode());
                }
            }
        });
    }

    private void toggleEscState() {
        escSwitchStage = !escSwitchStage;
    }











    private void visibility() {
        snakeCanvas.setVisible(true);
        eatableCanvas.setVisible(false);
        vBoxPausedGame.setVisible(false);
    }


    private void setStartDirection() {
        snake.setDirectionable(new StillDirection());
    }


    public void onResume(){
        vBoxPausedGame.setVisible(false);
        toggleEscState();

    }

    public void onMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }

    public void onExit(){
        System.exit(0);
    }


}
