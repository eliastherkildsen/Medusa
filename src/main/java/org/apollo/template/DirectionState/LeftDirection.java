package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Snake;

public class LeftDirection implements Directionable{
    @Override
    public void change(Snake snake, KeyCode keyCode) {
        if (!snake.getDirectionable().getDirection().equals("RIGHT")){
            snake.setDirectionable(new LeftDirection());
        }
    }

    @Override
    public String getDirection() {
        return "LEFT";
    }
}
