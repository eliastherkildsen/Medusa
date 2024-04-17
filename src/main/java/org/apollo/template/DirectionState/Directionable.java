package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Snake;

public interface Directionable {
    void change(Direction direction);
    String getStateAsString();
    public Direction getStateAsDirection();
}