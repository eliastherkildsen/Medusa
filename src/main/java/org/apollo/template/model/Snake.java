package org.apollo.template.model;

import javafx.scene.input.KeyCode;
import org.apollo.template.DirectionState.Directionable;
import org.apollo.template.DirectionState.StillDirection;


public class Snake implements Character {

    private Directionable directionable;





    public Snake() {
        this.setDirectionable(new StillDirection());
    }

    public void setDirectionable(Directionable directionable) {
        this.directionable = directionable;
    }




    public void moveSnake(KeyCode keyCodePressed){
        directionable.change(this, keyCodePressed);
    }


}
