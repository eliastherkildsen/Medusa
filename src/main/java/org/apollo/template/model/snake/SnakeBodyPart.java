package org.apollo.template.model.snake;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import org.apollo.template.model.Direction;

/**
 * This class creates snake body parts.
 */
public class SnakeBodyPart extends Circle {

    private final Color ODD_COLOR = Color.GREENYELLOW;
    private final Color EVEN_COLOR = Color.GREENYELLOW;
    private static int COUNT = 0;
    private double oldX, oldY;
    private final int DIAMETER = 20;


    public SnakeBodyPart() {

        COUNT ++;
        if (COUNT % 2 == 0){
            setFill(ODD_COLOR);
        }
        else setFill(EVEN_COLOR);


        int DIAMETER = 25;
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
