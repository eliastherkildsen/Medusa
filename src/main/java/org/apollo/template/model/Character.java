package org.apollo.template.model;

import org.apollo.template.DirectionState.Directionable;

public interface Character extends Updateable {

    public void setDirectional (Directionable directionable);

    public void setXVelocity(double xVelocity);
    public void setYVelocity(double yVelocity);
    public double getMovementSpeed();
    public void addPoint(int point);
    public int getPoint();
    public void addBodyPart();
    public void removeBodyPart();

    @Override
    public void update();
}
