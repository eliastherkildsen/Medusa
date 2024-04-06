package org.apollo.template.Controller;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import org.apollo.template.DirectionState.DownDirection;
import org.apollo.template.DirectionState.LeftDirection;
import org.apollo.template.DirectionState.RightDirection;
import org.apollo.template.DirectionState.UpDirection;
import org.apollo.template.View.BorderPaneRegion;
import org.apollo.template.View.ViewList;
import org.apollo.template.model.Snake;

public class GameController {

    // TODO - burde dette være Character character = new Character(); ift. Maintainability??
    Snake snake = new Snake();

    @FXML
    private StackPane gameStackPane;



    /**
     * Method for handling key press events to change the direction of the snake.
     * If a key is pressed corresponding to one of the four direction keys (UP, DOWN, LEFT, RIGHT),
     * the snake's direction is updated accordingly.
     *
     * @param keyEvent a KeyEvent object containing information about the key press event that triggered the action
     */
    @FXML
    public void handleKeyPress(KeyEvent keyEvent){

        if (keyEvent.getCode() == KeyCode.UP) {
            snake.setDirectionable(new UpDirection());
            //???.change(new UpDirection());
            //System.out.println("UP");}
        }
        if (keyEvent.getCode() == KeyCode.DOWN) {
            snake.setDirectionable(new DownDirection());
            //???.change(new DownDirection());
            //System.out.println("DOWN");}
        }
        if (keyEvent.getCode() == KeyCode.LEFT) {
            snake.setDirectionable(new LeftDirection());
            //???.change(new LeftDirection());
            //System.out.println("LEFT");}
        }
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            snake.setDirectionable(new RightDirection());
            //???.change(new RightDirection());
            //System.out.println("RIGHT");}
        }
    }


    public void onMainMenu(){
        MainController.getInstance().changeView(ViewList.MENU, BorderPaneRegion.CENTER);
    }

}
