package org.apollo.template.DirectionState;

import org.apollo.template.model.Snake;

public class StillDirection implements Directionable{
    @Override
    public void change(Snake snake) {

    }

    @Override
    public String getDirection() {
        return "STILL";
    }
}
