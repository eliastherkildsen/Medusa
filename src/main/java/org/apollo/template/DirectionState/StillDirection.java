package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class StillDirection implements Directionable{
    private Character character;
    private KeyCode keyCode;

    public StillDirection (Character character){
        this.character = character;
    }
    /**
     * Method for changing the snake's direction based on the pressed key code - either up, down, left or right direction.
     * @param keyCode The key code representing the direction change.
     */
    @Override
    public void change(KeyCode keyCode) {
        if (keyCode.equals(KeyCode.UP)){
            character.setDirectional(new UpDirection());
            DebugMessage.info(this, "Up direction");
        }
        if (keyCode.equals(KeyCode.DOWN)){
            character.setDirectional(new DownDirection());
            DebugMessage.info(this, "Down direction");
        }
        if (keyCode.equals(KeyCode.LEFT)){
            character.setDirectional(new LeftDirection());
            DebugMessage.info(this, "Left direction");
        }
        if (keyCode.equals(KeyCode.RIGHT)){
            character.setDirectional(new RightDirection());
            DebugMessage.info(this, "Right direction");
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
