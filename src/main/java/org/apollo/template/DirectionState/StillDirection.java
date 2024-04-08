package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Snake;

public class StillDirection implements Directionable{
    @Override
    public void change(Snake snake, KeyCode keyCode) {

    }

    @Override
    public String getDirection() {
        return "STILL";
    }
}
