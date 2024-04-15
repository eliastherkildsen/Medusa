package org.apollo.template.model.Food;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Food extends Rectangle implements Eatable  {
    private final int POINT;
    private final double X_POS, Y_POS;




    protected Food(int point, double xPos, double yPos) {
        this.POINT = point;
        this.X_POS = xPos;
        this.Y_POS = yPos;

        this.setLayoutX(X_POS);
        this.setLayoutY(Y_POS);
        this.setHeight(2);
        this.setWidth(2);
    }


    public int getPOINT() {
        return POINT;
    }

    public double getXPos() {
        return X_POS;
    }

    public double getYPos() {
        return Y_POS;
    }

    public boolean isColided(double x, double y){

        if (x == X_POS && y == Y_POS) return true;

        return false;

    }
}