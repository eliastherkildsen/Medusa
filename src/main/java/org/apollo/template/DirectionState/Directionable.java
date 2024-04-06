package org.apollo.template.DirectionState;

import org.apollo.template.model.Snake;

public interface Directionable {

    void change(Snake snake);

    String getDirection();

}
