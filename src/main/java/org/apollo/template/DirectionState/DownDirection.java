package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class DownDirection implements Directionable{

    /**
     * Method for changing the snake's direction based on the pressed key code - either left or right direction.
     * Note: The "up" direction change is not allowed as the snake cannot turn 180 degrees.
     *
     * @param snake the snake object whose direction will be changed
     * @param keyCode the key code representing the direction change
     */
    @Override
    public void change(Snake snake, KeyCode keyCode) {

        if (keyCode.equals(KeyCode.LEFT)){
            snake.setDirectional(new LeftDirection());
            DebugMessage.info(this, "Left direction");
            snake.setXVelocity(-snake.getMovementSpeed());

        }
        if (keyCode.equals(KeyCode.RIGHT)){
            snake.setDirectional(new RightDirection());
            DebugMessage.info(this, "Right direction");
            snake.setXVelocity(snake.getMovementSpeed());

        }
    }

    @Override
    public KeyCode getStateAsKey() {
        return null;
    }

    @Override
    public void getYVelocity() {

    }

    @Override
    public void getXVelocity() {

    }

    @Override
    public void getRotation() {

    }

    @Override
    public void getDirection() {

    }

    @Override
    public String getStateAsString() {
        return null;
    }

}
