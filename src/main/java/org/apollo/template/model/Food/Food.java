package org.apollo.template.model.Food;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.apollo.template.model.snake.SnakeHead;

import java.time.LocalDateTime;

public abstract class Food extends Rectangle implements Eatable  {
    private final int POINT;
    private final double X_POS, Y_POS;
    private Integer lifeTime;
    private final LocalDateTime creationTime = LocalDateTime.now();
    private boolean alive;


    protected Food(int point, double xPos, double yPos) {
        this.POINT = point;
        this.X_POS = xPos;
        this.Y_POS = yPos;

        this.setX(X_POS);
        this.setY(Y_POS);
        this.setWidth(2);
        this.setHeight(2);
        this.setScaleX(20);
        this.setScaleY(20);

        alive = true;

    }

    protected Food(int point, double xPos, double yPos, Integer lifeTime) {
        this(point, xPos, yPos);
        this.lifeTime = lifeTime;

    }

    public void setLifeTime(Integer lifeTime) {
        this.lifeTime = lifeTime;
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

    public boolean isColided(SnakeHead snakeHead){
        return this.getBoundsInParent().intersects(snakeHead.getBoundsInParent());
    }

    public boolean isAlive() {
        return alive;
    }


    @Override
    public void update() {

        if (lifeTime == null) return;

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = creationTime.plusSeconds((long)lifeTime);

        alive = (now.isBefore(before));

        System.out.println("NOW : " + now);
        System.out.println("BEFORE : " + before);

    }
}