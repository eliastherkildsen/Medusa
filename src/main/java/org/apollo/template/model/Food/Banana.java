package org.apollo.template.model.Food;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import org.apollo.template.model.Character;

public class Banana extends Food{

    private Image imageBanana = new Image("pngtree-banana-fresh-healthy-yellow-png-image_3356827.png");

    public Image getImageBanana() {
        return imageBanana;
    }

    public Banana(double x, double y) {

        super(10, x, y);
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
