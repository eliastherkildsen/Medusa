package org.apollo.template.DirectionState;


import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Character;
import org.apollo.template.model.Direction;

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
        }
        if (direction.equals(Direction.RIGHT)){
            character.setDirectional(new RightDirection(character));
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
