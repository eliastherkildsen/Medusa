package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class StillDirection implements Directionable{
    @Override
    public void change(Snake snake, KeyCode keyCode) {
        if (keyCode.equals(KeyCode.UP)){
            snake.setDirectional(new UpDirection());
            DebugMessage.info(this, "Up direction");
        }
        if (keyCode.equals(KeyCode.DOWN)){
            snake.setDirectional(new DownDirection());
            DebugMessage.info(this, "Down direction");
        }
        if (keyCode.equals(KeyCode.LEFT)){
            snake.setDirectional(new LeftDirection());
            DebugMessage.info(this, "Left direction");
        }
        if (keyCode.equals(KeyCode.RIGHT)){
            snake.setDirectional(new RightDirection());
            DebugMessage.info(this, "Right direction");
        }

    }


}
