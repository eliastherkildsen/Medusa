package org.apollo.template.DirectionState;

import org.apollo.template.model.Snake;

public class UpDirection implements Directionable{
    @Override
    public void change(Snake snake) {
        if (!snake.getDirectionable().getDirection().equals("DOWN")){
            snake.setDirectionable(new UpDirection());
        }
    }

    @Override
    public String getDirection() {
        return "UP";
    }
}
