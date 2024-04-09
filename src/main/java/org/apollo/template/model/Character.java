package org.apollo.template.model;

import org.apollo.template.DirectionState.Directionable;

public interface Character {

    public void setDirectional (Directionable directionable);

    public void setXVelocity(double xVelocity);
    public void setYVelocity(double yVelocity);
    public void setRotation(int rotation);
}
