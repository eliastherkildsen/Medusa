package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Snake;

public class DownDirection implements Directionable{

    /**
     * Method for changing the snake's direction based on the pressed key code - either left or right direction.
     * Note: The "up" direction change is not allowed as the snake cannot turn 180 degrees.
     *
     * @param snake The snake object whose direction will be changed.
     * @param keyCode The key code representing the direction change.
     */
    @Override
    public void change(Snake snake, KeyCode keyCode) {

        if (keyCode.equals(KeyCode.LEFT)){
            snake.setDirectionable(new LeftDirection());
            DebugMessage.info(this, "Left direction");
        }
        if (keyCode.equals(KeyCode.RIGHT)){
            snake.setDirectionable(new RightDirection());
            DebugMessage.info(this, "Right direction");
        }
    }

}
