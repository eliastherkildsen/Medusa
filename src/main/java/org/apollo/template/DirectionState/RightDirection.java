package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Character;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Snake;

public class RightDirection implements Directionable{
    private Character character;

    public RightDirection (Character character){
        this.character = character;
        changeSpeedDirection();
    }

    private void changeSpeedDirection(){
        character.setXVelocity(character.getMovementSpeed());
        character.setRotation(270);
    }

    /**
     * Method for changing the snake's direction based on the pressed key code - either up or down direction.
     * Note: The "right" direction change is not allowed as the snake cannot turn 180 degrees.
     * @param direction The enum representing the direction change.
     */
    @Override
    public void change(Direction direction) {
        if (direction.equals(Direction.UP)){
            character.setDirectional(new UpDirection(character));
            DebugMessage.info(this, "Up direction");
        }
        if (direction.equals(Direction.DOWN)){
            character.setDirectional(new DownDirection(character));
            DebugMessage.info(this, "Down direction");
        }
    }

    @Override
    public String getStateAsString() {
        return "RIGHT";
    }

    @Override
    public Direction getStateAsDirection() {
        return Direction.RIGHT;
    }
}
