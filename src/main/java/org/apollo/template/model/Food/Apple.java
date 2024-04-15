package org.apollo.template.model.Food;

import javafx.scene.paint.Color;
import org.apollo.template.model.Character;

public class Apple extends Food{

    public Apple(double x, double y) {

        super(1, x, y);
        super.setFill(Color.RED);

    }

    @Override
    public void eat(Character character) {
        character.addPoint(super.getPOINT());
        character.addBodyPart();
    }

}
