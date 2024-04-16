package org.apollo.template.model.Food;

import javafx.scene.paint.Color;
import org.apollo.template.model.Character;

public class Apple extends Food{

    public Apple(double x, double y) {

        super(20, x, y);
        super.setFill(Color.RED);
        super.setScaleX(20);
        super.setScaleY(20);
        super.setSoundEffect(SoundEffect.EATING);

    }

    @Override
    public void eat(Character character) {
        character.addPoint(super.getPOINT());
        character.addBodyPart();
    }

}
