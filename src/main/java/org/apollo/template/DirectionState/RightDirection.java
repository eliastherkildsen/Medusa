package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Snake;

public class RightDirection implements Directionable{
    @Override
    public void change(Snake snake, KeyCode keyCode) {
        if (!snake.getDirectionable().getDirection().equals("LEFT")){
            snake.setDirectionable(new RightDirection());
        }
    }

    @Override
    public String getDirection() {
        return "RIGHT";
    }
}
