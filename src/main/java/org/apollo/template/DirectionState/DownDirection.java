package org.apollo.template.DirectionState;

import org.apollo.template.model.Snake;

public class DownDirection implements Directionable{
    @Override
    public void change(Snake snake) {
        if (!snake.getDirectionable().getDirection().equals("UP")){
            snake.setDirectionable(new RightDirection());
        }
    }

    @Override
    public String getDirection() {
        return "DOWN";
    }
}
