package org.apollo.template.model;

import javafx.animation.RotateTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;
import org.apollo.template.DirectionState.Directionable;
import org.apollo.template.DirectionState.StillDirection;
import org.apollo.template.DirectionState.UpDirection;
import org.apollo.template.model.snake.SnakeHead;


public class Snake implements Character {

    // region instance variables
    private Directionable directionable;
    private SnakeHead snakeHead;
    private double xVelocity, yVelocity;
    private double xPos = 200;
    private double yPos = 200;
    private double movementSpeed = 25;
    private int rotation = 0;

    // endregion


    public Snake() {
        this.setDirectional(new StillDirection(this));
        this.snakeHead = new SnakeHead();
        setStartingPos(200,200);

    }

    public void setStartingPos(double x, double y){
        snakeHead.setLayoutX(x);
        snakeHead.setLayoutY(y);
    }


    public void moveSnake(Direction direction){
        directionable.change(direction);
        //rotateSnake();
    }
    public void updateSnakePosition(){

        xPos = snakeHead.getLayoutX();
        yPos = snakeHead.getLayoutY();

        snakeHead.setLayoutX(xPos += xVelocity);
        snakeHead.setLayoutY(yPos += yVelocity);

    }
    //TODO doesnt work as intended, needs refactor.
    private void rotateSnake(){
        Rotate rotate = new Rotate();
        rotate.setPivotX(snakeHead.getWidth() / 2);
        rotate.setPivotY(snakeHead.getHeight() / 2);

        rotate.setAngle(rotation);
        snakeHead.getTransforms().add(rotate);
    }

    // region getter & setters
    public void setXVelocity(double xVelocity) {

        // resetting the velocity, to make sure that we do not move the snake in 2 directions.
        yVelocity = 0;

        this.xVelocity = xVelocity;
    }
    public void setYVelocity(double yVelocity) {
        xVelocity = 0;
        this.yVelocity = yVelocity;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }
    public SnakeHead getSnakeHead(){
        return snakeHead;
    }
    public void setDirectional(Directionable directionable) {
        this.directionable = directionable;
    }
    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
    public double getXPos() {
        return xPos;
    }
    public double getYPos() {
        return yPos;
    }
    // endregion

}
