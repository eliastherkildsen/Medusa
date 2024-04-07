package org.apollo.template.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Head {
    /*
    My arrays account for rotation and correction for x, y
    Index: 0 = Rotation, 1 = X, 2 = Y
    */
    private final int[] RIGHT = {
            0, 0, 0
    };
    private final int[] DOWN = {
            90, 23, 0
    };
    private final int[] LEFT = {
            180, 20, 23
    }; // x+20,y+23
    private final int[] UP = {
            270, 0, 23
    }; // y+23;
    private Color headColor = SnakeDefaultColors.BODYCOLOR;
    private Color eyesColor = SnakeDefaultColors.EYESCOLOR;
    private Color noseColor = SnakeDefaultColors.NOSECOLOR;
    private final Canvas canvas;
    private final GraphicsContext gc;

    /**
     * The Head class is responsible for drawing and maintaining the head of the snake.
     * It assumes that we are working on a 20x20 pixel grid.
     * TODO Currently relies on Canvas, might be better with GraphicsContext? Refactor when map is done.
     * TODO Store information about logic position of the snakes head, not implemented yet as its an easy implementation and requires logic to be written first.
     * @param object Canvas
     */
    Head (Canvas object){
        canvas = object;
        gc = object.getGraphicsContext2D();
    }

    /**
     * Might removed this constructor, replace with one that accepts X and Y in relation to the logic.
     * That would also allow you to create the object and spawn it in the world instantly.
     * Colouring could or should be done by calling the setters anyway, and not on creation. (I think?)
     * @param object
     * @param colorHead
     * @param colorEyes
     * @param colorNose
     */
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
        gc.rotate(directionValueRotation(direction)[0]); // Rotate the convas..
        gc.translate(-x,-y); // Move back to where we want it to be.

        drawHead((x+directionValueRotation(direction)[1]),(y+directionValueRotation(direction)[2])); //Draw fucking head.

        gc.restore(); //Restore to our saved state. - Madness
    }
    private int[] directionValueRotation (String direction){
        return switch (direction) {
            case "UP" -> UP;
            case "DOWN" -> DOWN;
            case "LEFT" -> LEFT;
            case "RIGHT" -> RIGHT;
            default -> new int[]{0,0,0}; //We should never end here?
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
