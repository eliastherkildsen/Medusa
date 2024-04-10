package org.apollo.template.model;

import javafx.scene.paint.Color;
import org.apollo.template.DirectionState.Directionable;
import org.apollo.template.DirectionState.StillDirection;
import org.apollo.template.model.snake.SnakeBodyPart;
import org.apollo.template.model.snake.SnakeHead;

import java.util.LinkedList;
import java.util.List;


public class Snake implements Character {

    // region instance variables
    private Directionable directionable;
    private SnakeHead snakeHead;
    private double xVelocity, yVelocity;
    private double xPos = 225;
    private double yPos = 225;
    private double movementSpeed = 50;
    private List<SnakeBodyPart> snakeBodyPartList;
    private boolean dead = false;
    private int point;

    // endregion

    public Snake() {
        this.setDirectional(new StillDirection(this));
        this.snakeHead = new SnakeHead(directionable.getStateAsDirection());
        setStartingPos(xPos,yPos);

        this.snakeBodyPartList = new LinkedList<>();

    }
    @Override
    public void addBodyPart(){
        this.snakeBodyPartList.add(new SnakeBodyPart());
    }

    @Override
    public void removeBodyPart() {
        this.snakeBodyPartList.removeLast();
    }

    @Override
    public void update() {
        updateBodyPartPosition();
        updateSnakePosition();
        dead = checkBodyPartColission();

    }

    @Override
    public void addPoint(int point) {
        this.point += point;
    }

    private void updateBodyPartPosition() {


        for (int i = 0; i < snakeBodyPartList.size() ; i++) {

            if (i == 0){
                snakeBodyPartList.get(i).move(xPos, yPos);
            }

            else {
                snakeBodyPartList.get(i).move(snakeBodyPartList.get(i - 1).getOldX(), snakeBodyPartList.get(i - 1).getOldY());
            }

        }

    }

    private boolean checkBodyPartColission(){
        // check if the head collides with the body.
        for (SnakeBodyPart snakeBodyPart : snakeBodyPartList){
            if (xPos == snakeBodyPart.getTranslateX() && yPos == snakeBodyPart.getTranslateY()) return true;
        }

        return false;


    }

    public void moveSnake(Direction direction){
        directionable.change(direction);
        snakeHead.changeHeadRotation(directionable.getStateAsDirection());
    }

    public void updateSnakePosition(){

        xPos = snakeHead.getLayoutX();
        yPos = snakeHead.getLayoutY();

        snakeHead.setLayoutX(xPos += xVelocity);
        snakeHead.setLayoutY(yPos += yVelocity);

    }
    // region getter & setters


    @Override
    public int getPoint() {
        return this.point;
    }

    public boolean isDead() {
        return dead;
    }

    public List<SnakeBodyPart> getSnakeBodyPartList() {
        return snakeBodyPartList;
    }

    public void setStartingPos(double x, double y){
        snakeHead.setLayoutX(x);
        snakeHead.setLayoutY(y);
    }
    public void setXVelocity(double xVelocity) {

        // resetting the velocity, to make sure that we do not move the snake in 2 directions.
        yVelocity = 0;

        this.xVelocity = xVelocity;
    }
    public void setYVelocity(double yVelocity) {
        xVelocity = 0;
        this.yVelocity = yVelocity;
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

    public Direction getDirection() {
        return directionable.getStateAsDirection();
    }
    // endregion

}
