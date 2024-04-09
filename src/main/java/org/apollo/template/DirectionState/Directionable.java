package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Direction;
import org.apollo.template.model.Snake;

public interface Directionable {
    void change(KeyCode keyCode);
    KeyCode getStateAsKey ();
    void getYVelocity ();
    void getXVelocity ();
    void getRotation ();
    void getDirection();
    String getStateAsString();
}