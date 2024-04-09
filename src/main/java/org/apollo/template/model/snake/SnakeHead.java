package org.apollo.template.model.snake;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SnakeHead extends Pane {
    private SnakeEye rightEye = new SnakeEye(2f);
    private SnakeEye leftEye = new SnakeEye(2f);
    private SnakeNose noseLeft = new SnakeNose(0.5F);
    private SnakeNose noseRight = new SnakeNose(0.5F);
    private SnakeHorn hornLeft = new SnakeHorn(5F);
    private SnakeHorn hornRight = new SnakeHorn(5F);
    private SnakeBody snakeHead = new SnakeBody(1F);

    public SnakeHead() {

        setTranslateX(200);
        setTranslateY(200);

        noseRight.setLayout(6, 16);
        noseLeft.setLayout(-6,16);
        rightEye.setLayout(-12, 0);
        rightEye.setRotate(Math.decrementExact(160));
        leftEye.setLayout(12, 0);
        leftEye.setRotate(Math.decrementExact(20));
        hornLeft.setLayout(-6,-26);
        hornRight.setLayout(2,-26);
        snakeHead.setLayout(0,0);


        getChildren().addAll(snakeHead, hornLeft, hornRight, noseLeft, noseRight, rightEye, leftEye);
    }

}
