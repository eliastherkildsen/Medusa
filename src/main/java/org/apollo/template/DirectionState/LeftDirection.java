package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Snake;

public class LeftDirection implements Directionable{
    @Override
    public void change(Snake snake, KeyCode keyCode) {
        if (keyCode.equals(KeyCode.UP)){
            snake.setDirectionable(new UpDirection());
            DebugMessage.info(this, "Up direction");
        }
        if (keyCode.equals(KeyCode.DOWN)){
            snake.setDirectionable(new DownDirection());
            DebugMessage.info(this, "Down direction");
        }
    }


}
