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
        character.setYVelocity(-character.getMovementSpeed());
    }

    /**
     * Method for changing the snake's direction based on the pressed key code - either left or right direction.
     * Note: The "down" direction change is not allowed as the snake cannot turn 180 degrees.
     * @param direction The enum representing the direction change.
     */

    @Override
    public void change(Direction direction) {
        if (direction.equals(Direction.LEFT)){
            character.setDirectional(new LeftDirection(character));
            DebugMessage.info(this, "Left direction");
        }
        if (direction.equals(Direction.RIGHT)){
            character.setDirectional(new RightDirection(character));
            DebugMessage.info(this, "Right direction");
        }
    }

    @Override
    public String getStateAsString() {
        return "UP";
    }
    public Direction getStateAsDirection(){
        return Direction.UP;
    }
}
