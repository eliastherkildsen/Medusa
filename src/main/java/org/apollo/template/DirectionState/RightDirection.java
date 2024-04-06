package org.apollo.template.DirectionState;

import org.apollo.template.model.Snake;

public class RightDirection implements Directionable{
    @Override
    public void change(Snake snake) {
        if (!snake.getDirectionable().getDirection().equals("LEFT")){
            snake.setDirectionable(new RightDirection());
        }
    }

    @Override
    public String getDirection() {
        return "RIGHT";
    }
}
