package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class LeftDirection implements Directionable{

    /**
     * Method for changing the snake's direction based on the pressed key code - either up or down direction.
     * Note: The "right" direction change is not allowed as the snake cannot turn 180 degrees.
     *
     * @param snake the snake object whose direction will be changed
     * @param keyCode the key code representing the direction change
     */
    @Override
    public void change(Snake snake, KeyCode keyCode) {
        if (keyCode.equals(KeyCode.UP)){
            snake.setDirectional(new UpDirection());
            DebugMessage.info(this, "Up direction");

            snake.setYVelocity(-snake.getMovementSpeed());

        }
        if (keyCode.equals(KeyCode.DOWN)){
            snake.setDirectional(new DownDirection());
            DebugMessage.info(this, "Down direction");
            snake.setYVelocity(snake.getMovementSpeed());

        }
    }


}
