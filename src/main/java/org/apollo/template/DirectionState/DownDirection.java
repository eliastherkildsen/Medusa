package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class DownDirection implements Directionable{
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

        System.out.println("NOTHING!");

    }

}
