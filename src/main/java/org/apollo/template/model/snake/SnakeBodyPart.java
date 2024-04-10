package org.apollo.template.model.snake;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * This class creates snake body parts.
 */
public class SnakeBodyPart extends Circle {

    private final Color ODD_COLOR = Color.GREEN;
    private final Color EVEN_COLOR = Color.GREENYELLOW;
    private static int COUNT = 0;
    private double oldX, oldY;
    public SnakeBodyPart() {

        COUNT ++;
        if (COUNT % 2 == 0){
            setFill(ODD_COLOR);
        }
        else setFill(EVEN_COLOR);


        int DIAMETER = 20;
        setRadius(DIAMETER);


    }

    public void move(double x, double y) {

        oldX = getTranslateX();
        oldY = getTranslateY();

        setTranslateX(x);
        setTranslateY(y);
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
}
