package org.apollo.template.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.apollo.template.App;
import org.apollo.template.DirectionState.*;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Food.Apple;
import org.apollo.template.model.Food.Banana;
import org.apollo.template.model.Food.Food;
import org.apollo.template.model.Map;
import org.apollo.template.model.Snake;
import org.apollo.template.model.Updateable;
import org.apollo.template.model.snake.SnakeBodyPart;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable, Updateable {

    // region instance variables

    @FXML
    private StackPane gameStackPane;
    @FXML
    private ImageView gameView;
    @FXML
    private Canvas eatableCanvas;
    @FXML
    private Pane snakeCanvas, boardPane, eatableLayer;
    @FXML
    private Label scoreLabel, pausedGameLabel, xPos, yPos, directionLab;
    @FXML
    private VBox vBoxPausedGame;
    @FXML
    private Button btnResume, btnMainMenu, btnExit;
    private boolean pausedState = false;
    private Map map = new Map();

    private Snake snake = new Snake();
    private Timeline gameLoop;
    private final javafx.util.Duration GAME_TICK = javafx.util.Duration.millis(200); // Adjust tick duration as needed
    private List<Food> foodList;

    private SettingsController settingsController;


    // endregion

    /**
     * Initializes the game by setting the starting direction of the snake, adjusting visibility of game elements,
     * setting focus traversal for the game stack pane, and loading key press event listeners.
     *
     * @param url The location for resolving paths, or null if unknown.
     * @param resourceBundle The resource bundle for this controller, or null if none.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // instantiating food list.
        foodList = new LinkedList<>();

        setStartDirection();
        menuVisibility();
        gameStackPane.setFocusTraversable(true);

        loadListener();

        map.drawBackground(boardPane, App.screenWidth,App.screenHeight,50);

        // Initialize the game loop timer
        gameLoop = new Timeline(new KeyFrame(
                GAME_TICK,
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        // Update game logic here
                        update();
                    }
                }
        ));
        gameLoop.setCycleCount(Animation.INDEFINITE); // Run the timer indefinitely
        gameLoop.play(); // Start the game loop

    }

    @Override
    public void update() {

        // checks if the game is paused
        if (pausedState) return;

        // updating score.
        scoreLabel.setText(String.valueOf("SCORE: " + snake.getPoint()));

        // checks if the snake is on screen
        if (isOnScreen() && !snake.isDead()) {
            // check collision with food
            checkCollisionFood();
            // updating debug information.
            updateDebugLab();
            // rendering all grapes
            render();

            snake.update();

        }
    }

    /**
     * Method checks if the snake has collided with any of the food.
     */
    private void checkCollisionFood() {
        for (Food food : foodList){
            if(food.isColided(snake.getXPos(), snake.getYPos())){

                settingsController.useSoundEffect(food.getSoundEffect());

                food.eat(snake);
                foodList.remove(food);
                eatableLayer.getChildren().remove(food);
            }
        }

    }

    private void render() {

        // checks if the snake head has been drawn.
        if (!snakeCanvas.getChildren().contains(snake.getSnakeHead())){
            snakeCanvas.getChildren().add(snake.getSnakeHead());
        }

        // checks if all the body parts has been drawn.
        for (SnakeBodyPart sbp : snake.getSnakeBodyPartList()){
            if (!snakeCanvas.getChildren().contains(sbp)){
                snakeCanvas.getChildren().add(sbp);
            }
        }

        // checks if all the food in foodlist has benn drawn.
        for (Food food : foodList){
            if (!eatableLayer.getChildren().contains(food)){
                eatableLayer.getChildren().add(food);
            }
        }

    }

    private boolean isOnScreen(){

        if (snake.getXPos() <= 0 || snake.getXPos() >= snakeCanvas.getWidth()) return false;
        if (snake.getYPos() <= 0 || snake.getYPos() >= snakeCanvas.getWidth()) return false;

        return true;
    }

    private void updateDebugLab() {
        xPos.setText(String.valueOf(snake.getXPos()));
        yPos.setText(String.valueOf(snake.getYPos()));
        directionLab.setText(String.valueOf(snake.getDirection()));
    }

    /**
     * Method for handling key press events to change the direction of the snake.
     * If a key is pressed corresponding to one of the four direction keys (UP, DOWN, LEFT, RIGHT), the snake's
     * direction is updated accordingly.
     * If the ESC key is pressed, the game is paused.
     *
     * If the ESC key is pressed, the game is paused if it is currently running, or resumed if it is already paused.
     */
    private void loadListener() {
        gameStackPane.setOnKeyPressed(keyEvent -> {

            // handles key press escape - paused game
            if (keyEvent.getCode().equals(KeyCode.ESCAPE) || keyEvent.getCode().equals(KeyCode.SPACE)){

                if (!pausedState) {
                    vBoxPausedGame.setVisible(true);
                }

                if (pausedState){
                    vBoxPausedGame.setVisible(false);
                }

                toggleEscState();

            }
            // handles key press directions - up, down, left, right
            if (keyEvent.getCode().equals(KeyCode.UP) || keyEvent.getCode().equals(KeyCode.W)){
                snake.moveSnake(Direction.UP);
            }
            if (keyEvent.getCode().equals(KeyCode.DOWN) || keyEvent.getCode().equals(KeyCode.S)){
                snake.moveSnake(Direction.DOWN);
            }
            if (keyEvent.getCode().equals(KeyCode.LEFT) || keyEvent.getCode().equals(KeyCode.A)){
                snake.moveSnake(Direction.LEFT);
            }
            if (keyEvent.getCode().equals(KeyCode.RIGHT) || keyEvent.getCode().equals(KeyCode.D)){
                snake.moveSnake(Direction.RIGHT);
            }

            if (keyEvent.getCode().equals(KeyCode.R)){
                snake.addBodyPart();
            }

            if (keyEvent.getCode().equals(KeyCode.Q)){
                foodList.add(new Apple(125, 125));

                foodList.add(new Banana(325,325));

            }


            if ((keyEvent.getCode().equals(KeyCode.G))){
                MainController.getInstance().changeView(ViewList.GAMEOVER,BorderPaneRegion.CENTER);
            }


        });
    }


    /**
     * Method for toggling the escape state.
     */
    private void toggleEscState() {
        pausedState = !pausedState;
    }


    /**
     * Method for setting visibility of game elements at the beginning of the game (called during initialization).
     */
    private void menuVisibility() {
        snakeCanvas.setVisible(true);
        eatableCanvas.setVisible(false);
        vBoxPausedGame.setVisible(false);
    }


    /**
     * Method for setting the snake's starting direction.
     */
    private void setStartDirection() {
        snake.setDirectional(new StillDirection(snake));
        DebugMessage.info(this, "Setting the snake's starting direction to \"StillDirection\"");
    }


    // region buttons

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

    @FXML
    protected void btnADD(){
        snake.addBodyPart();
    }

    // endregion




}
