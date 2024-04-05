package org.apollo.template.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Body {
    private Color colorBody = SnakeDefaultColors.BODYCOLOR;
    private Canvas canvas;
    private GraphicsContext gc = canvas.getGraphicsContext2D();

    Body(Canvas object){
        canvas = object;
    }
    Body(Canvas object, Color bodyColor){
        canvas = object;
        setColorBody(bodyColor);
    }
    public void renderBody(int x, int y){
        drawBody(x,y);
    }
    private void drawBody (int x, int y){
        gc.setFill(colorBody);
        gc.fillOval(x,y,20,20);
    }

    public void setColorBody(Color colorBody) {
        this.colorBody = colorBody;
    }
}
