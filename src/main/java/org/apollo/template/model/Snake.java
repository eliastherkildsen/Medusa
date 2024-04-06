package org.apollo.template.model;

import org.apollo.template.DirectionState.Directionable;
import org.apollo.template.DirectionState.StillDirection;

public class Snake implements Character {

    private Directionable directionable = null;



    public Snake() {
        this.setDirectionable(new StillDirection());
    }

    public Directionable getDirectionable() {
        return directionable;
    }

    public void setDirectionable(Directionable directionable) {
        this.directionable = directionable;
    }


}
