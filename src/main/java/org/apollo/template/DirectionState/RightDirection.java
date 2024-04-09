package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class RightDirection implements Directionable{
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
