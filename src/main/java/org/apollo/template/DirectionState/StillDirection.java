package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Character;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Snake;

public class StillDirection implements Directionable{
    private Character character;

    public StillDirection (Character character){
        this.character = character;
        changeSpeedDirection();
    }
    private void changeSpeedDirection(){
        character.setXVelocity(0);
        character.setYVelocity(0);
    }
    /**
     * Method for changing the snake's direction based on the pressed key code - either up, down, left or right direction.
     * @param direction The enum representing the direction change.
     */
    @Override
    public void change(Direction direction) {
        if (direction.equals(Direction.UP)){
            character.setDirectional(new UpDirection(character));
        }

        if (direction.equals(Direction.DOWN)){
            character.setDirectional(new DownDirection(character));
        }

        if (direction.equals(Direction.LEFT)){
            character.setDirectional(new LeftDirection(character));
        }

        if (direction.equals(Direction.RIGHT)){
            character.setDirectional(new RightDirection(character));
        }
    }
    @Override
    public String getStateAsString() {
        return "STILL";
    }

    @Override
    public Direction getStateAsDirection() {
        return Direction.STILL;
    }
}
