package org.apollo.template.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * TODO: NEEDS TO ACCOUNT FOR X and Y correction per comments on final variables RIGHT, DOWN, LEFT, RIGHT.
 */
public class Head {
    private final int RIGHT = 0;
    private final int DOWN = 90; // x+23
    private final int LEFT = 180; // x+20,y+23
    private final int UP = 270; // y+23;
    private Color headColor = SnakeDefaultColors.BODYCOLOR;
    private Color eyesColor = SnakeDefaultColors.EYESCOLOR;
    private Color noseColor = SnakeDefaultColors.NOSECOLOR;
    private Canvas canvas;
    private GraphicsContext gc;

    /**
     * The Headclass is responsible for drawing and maintaining the head of the snake.
     * TODO Currently relies on Canvas, might be better with GraphicsContext? Refactor when map is done.
     * @param object Canvas
     */
    Head (Canvas object){
        canvas = object;
        gc = object.getGraphicsContext2D();
    }
    Head (Canvas object, Color colorHead, Color colorEyes, Color colorNose){
        canvas = object;
        gc = object.getGraphicsContext2D();

        setHeadColor(colorHead);
        setEyesColor(colorEyes);
        setNoseColor(colorNose);
    }

    /**
     * Render our snakes head, I'm concerned this method will fuck with our canvas
     * It's working on its own, but I suspect it'll die when more is added.
     * Alternative solutions;
     * Switch to images.
     * Make a new image for each direction, up, down, left, right.
     * Make a simple circle as head.
     * @param x int
     * @param y int
     * @param direction String, UP, DOWN, LEFT, RIGHT
     */
    public void renderHead (int x, int y, String direction){

        gc.save(); //We need to save the current state of the graphics content
        gc.translate(x,y); //Translate to the center of our rotation
        gc.rotate(directionValueRotation(direction)); // Rotate the convas..
        gc.translate(-x,-y); // Move back to where we want it to be.

        drawHead(x,y); //Draw fucking head.

        gc.restore(); //Restore to our saved state. - Madness
    }
    private int directionValueRotation (String direction){
        return switch (direction) {
            case "UP" -> UP;
            case "DOWN" -> DOWN;
            case "LEFT" -> LEFT;
            case "RIGHT" -> RIGHT;
            default -> 0;
        };
    }

    private void drawHead (int x, int y){
        gc.setFill(headColor);
        gc.fillOval(x,y,16,16);
        gc.fillOval(x,y + 7,16,16);
        gc.fillOval(x + 5,y + 4,16,16);
        gc.setFill(eyesColor);
        gc.fillOval(x + 5,y + 3,5,5);
        gc.fillOval(x + 5,y + 15,5,5);
        gc.setFill(noseColor);
        gc.fillOval(x + 14,y + 7,3,3);
        gc.fillOval(x + 14,y + 14,3,3);
    }

    public void setHeadColor(Color headColor) {
        this.headColor = headColor;
    }

    public void setEyesColor(Color eyesColor) {
        this.eyesColor = eyesColor;
    }

    public void setNoseColor(Color noseColor) {
        this.noseColor = noseColor;
    }
}
