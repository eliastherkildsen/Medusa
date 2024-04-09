package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Character;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Snake;

public class UpDirection implements Directionable{
    private Character character;
    public UpDirection (Character character){
        this.character = character;
        changeSpeedDirection();
    }

    private void changeSpeedDirection(){
        character.setXVelocity(0);
        character.setYVelocity(0);


    }

    /**
     * Method for changing the snake's direction based on the pressed key code - either left or right direction.
     * Note: The "down" direction change is not allowed as the snake cannot turn 180 degrees.
     *
     * @param snake the snake object whose direction will be changed
     * @param keyCode the key code representing the direction change
     */

    @Override
    public void change(Direction direction) {
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
    public String getStateAsString() {
        return null;
    }
}
