package org.apollo.template.DirectionState;

import javafx.scene.input.KeyCode;
import org.apollo.template.model.Snake;

public interface Directionable {

    void change(Snake snake, KeyCode keyCode);

    String getDirection();

}
