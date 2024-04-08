package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Snake;

public class UpDirection implements Directionable{
    @Override
    public void change(Snake snake, KeyCode UP) {
        if (!snake.getDirectionable().getDirection().equals("DOWN")){
            snake.setDirectionable(new UpDirection());
        }
    }

    @Override
    public String getDirection() {
        return "UP";
    }
}
