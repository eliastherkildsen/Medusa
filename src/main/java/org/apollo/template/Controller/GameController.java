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
import org.apollo.template.Service.Debugger.DebugMessage;
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


    /**
     * Initializes the game by setting the starting direction of the snake, adjusting visibility of game elements,
     * setting focus traversal for the game stack pane, and loading key press event listeners.
     *
     * @param url The location for resolving paths, or null if unknown.
     * @param resourceBundle The resource bundle for this controller, or null if none.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        gameStackPane.setFocusTraversable(true);

        setStartDirection();
        visibility();

        loadListener();
    }


    /**
     * Method for handling key press events to change the direction of the snake.
     * If a key is pressed corresponding to one of the four direction keys (UP, DOWN, LEFT, RIGHT), the snake's
     * direction is updated accordingly.
     *
     * If the ESC key is pressed, the game is paused if it is currently running, or resumed if it is already paused.
     */
    private void loadListener() {
        gameStackPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                // handles key press escape - paused game
                if (keyEvent.getCode().equals(KeyCode.ESCAPE)){
                    if (!escSwitchStage) {
                        vBoxPausedGame.setVisible(true);
                    }

                    if (escSwitchStage){
                        vBoxPausedGame.setVisible(false);
                    }

                    DebugMessage.info("GameController - LoadListener","Escape key pressed");
                    toggleEscState();
                }

                // handles key press directions - up, down, left, right
                if (keyEvent.getCode().equals(KeyCode.UP)){
                    DebugMessage.info("GameController - LoadListener","Up key pressed");
                    snake.moveSnake(keyEvent.getCode());
                }
                if (keyEvent.getCode().equals(KeyCode.DOWN)){
                    DebugMessage.info("GameController - LoadListener","Down key pressed");
                    snake.moveSnake(keyEvent.getCode());
                }
                if (keyEvent.getCode().equals(KeyCode.LEFT)){
                    DebugMessage.info("GameController - LoadListener","Left key pressed");
                    snake.moveSnake(keyEvent.getCode());
                }
                if (keyEvent.getCode().equals(KeyCode.RIGHT)){
                    DebugMessage.info("GameController - LoadListener","Right key pressed");
                    snake.moveSnake(keyEvent.getCode());
                }
            }
        });
    }


    /**
     * Method for toggling the escape state.
     */
    private void toggleEscState() {
        escSwitchStage = !escSwitchStage;
    }


    /**
     * Method for setting visibility of game elements at the beginning of the game (called during initialization).
     */
    private void visibility() {
        snakeCanvas.setVisible(true);
        eatableCanvas.setVisible(false);
        vBoxPausedGame.setVisible(false);
    }


    /**
     * Method for setting the snake's starting direction.
     */
    private void setStartDirection() {
        snake.setDirectionable(new StillDirection());
        DebugMessage.info(this, "Setting the snake's starting direction to \"StillDirection\"");
    }


    /**
     * Method for resuming the game from the paused state by hiding the paused game view and toggling the escape state.
     */
    public void onResume(){
        vBoxPausedGame.setVisible(false);
        toggleEscState();
    }


    /**
     * Method for navigating to the main menu view.
     */
    public void onMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }


    /**
     * Method for exiting the application by terminating the JVM process.
     */
    public void onExit(){
        System.exit(0);
    }


}
