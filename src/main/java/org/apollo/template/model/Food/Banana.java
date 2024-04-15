package org.apollo.template.model.Food;

import javafx.scene.paint.Color;
import org.apollo.template.model.Character;

public class Banana extends Food{

    public Banana(double xPos, double yPos) {
        super(5, xPos, yPos);
        setFill(Color.YELLOW);
        super.setLifeTime(8);
    }

    @Override
    public void eat(Character character) {
        character.addPoint(getPOINT());
        character.addBodyPart();
        character.addBodyPart();
    }
}
