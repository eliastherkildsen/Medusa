package org.apollo.template.model.Food;

import javafx.scene.paint.Color;
import org.apollo.template.model.Character;
import org.apollo.template.model.snake.gameState;

public class Chilli extends Food{

    @Override
    public void eat(Character character) {
        gameState.interval = 10;
        character.setColor(Color.RED);
        character.addBodyPart();
    }

    public Chilli(double xPos, double yPos) {
        super(20, xPos, yPos);
        this.setFill(Color.PINK);
        setLifeTime(5);


    }
}
