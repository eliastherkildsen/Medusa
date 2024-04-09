package org.apollo.template.model.snake;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.apollo.template.model.Direction;

public class SnakeHead extends Pane {
    private SnakeEye rightEye = new SnakeEye(2f);
    private SnakeEye leftEye = new SnakeEye(2f);
    private SnakeNose noseLeft = new SnakeNose(0.5F);
    private SnakeNose noseRight = new SnakeNose(0.5F);
    private SnakeHorn hornLeft = new SnakeHorn(5F);
    private SnakeHorn hornRight = new SnakeHorn(5F);
    private SnakeBody snakeHead = new SnakeBody(2F);

    public SnakeHead(Direction direction) {
        changeHeadRotation(direction);
        getChildren().addAll(snakeHead, hornLeft, hornRight, noseLeft, noseRight, rightEye, leftEye);
        /**
        noseRight.setLayout(6, 16);
        noseLeft.setLayout(-6,16);
        rightEye.setLayout(-12, 0);
        rightEye.setRotate(Math.decrementExact(160));
        leftEye.setLayout(12, 0);
        leftEye.setRotate(Math.decrementExact(20));
        hornLeft.setLayout(-6,-26);
        hornRight.setLayout(2,-26);
         **/
    }
    public void changeHeadRotation(Direction direction){
        switch (direction) {
            case UP:
                noseRight.setLayout(-6, -16);
                noseLeft.setLayout(6, -16);
                rightEye.setLayout(12, 0);
                leftEye.setLayout(-12, 0);
                hornLeft.setLayout(6, 26);
                hornRight.setLayout(-2, 26);
                break;
            case DOWN:
                noseRight.setLayout(6, 16);
                noseLeft.setLayout(-6, 16);
                rightEye.setLayout(-12, 0);
                leftEye.setLayout(12, 0);
                hornLeft.setLayout(-6, -26);
                hornRight.setLayout(2, -26);
                break;
            case LEFT:
                noseRight.setLayout(-16, -6);
                noseLeft.setLayout(-16, 6);
                rightEye.setLayout(0, 12);
                leftEye.setLayout(0, -12);
                hornLeft.setLayout(10, 2);
                hornRight.setLayout(10, -6);
                break;
            case RIGHT:
                noseRight.setLayout(16, 6);
                noseLeft.setLayout(16, -6);
                rightEye.setLayout(0, -12);
                leftEye.setLayout(0, 12);
                hornLeft.setLayout(-26, -6);
                hornRight.setLayout(-26, 2);
                break;
        }
        snakeHead.setLayout(0,0);
    }

}