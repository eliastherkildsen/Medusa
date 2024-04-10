package org.apollo.template.model.snake;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Direction;

public class SnakeHead extends Pane {
    private SnakeEye rightEye = new SnakeEye(2f);
    private SnakeEye leftEye = new SnakeEye(2f);
    private SnakeNose noseLeft = new SnakeNose(0.5F);
    private SnakeNose noseRight = new SnakeNose(0.5F);
    private SnakeHorn hornLeft = new SnakeHorn(5F,1F);
    private SnakeHorn hornRight = new SnakeHorn(5F,1F);
    private SnakeBody snakeHead = new SnakeBody(2F);
    private Direction directionNow;

    public SnakeHead(Direction direction) {
        DebugMessage.info(this.getClass().getSimpleName(),"Creating Snake Head");
        changeHeadRotation(direction);
        directionNow = direction;
        getChildren().addAll(snakeHead, hornLeft, hornRight, noseLeft, noseRight, rightEye, leftEye);
    }

    /**
     *
     * @param direction
     */
    public void changeHeadRotation(Direction direction){
        if (directionNow == direction){
            DebugMessage.info("SnakeHead - changeHeadRotation", "No Change to head direction");
            return;
        }
        directionNow = direction;
        DebugMessage.info("SnakeHead - changeHeadRotation","Setting Snake Head direction: " + direction);
        switch (direction) {
            case UP:
                noseRight.setLayout(-6, -16);
                noseLeft.setLayout(6, -16);
                rightEye.setLayout(12, 0);
                leftEye.setLayout(-12, 0);
                hornLeft.setLayout(6, 26);
                hornLeft.setSizeHeightAndWidth(5F,1F);
                hornRight.setLayout(-2, 26);
                hornRight.setSizeHeightAndWidth(5F,1F);
                break;
            case DOWN:
                hornLeft.setSizeHeightAndWidth(5F, 1F);
                hornRight.setSizeHeightAndWidth(5F,1F);
                noseRight.setLayout(6, 16);
                noseLeft.setLayout(-6, 16);
                rightEye.setLayout(-12, 0);
                leftEye.setLayout(12, 0);
                hornLeft.setLayout(-6, -26);
                hornRight.setLayout(2, -26);
                break;
            case LEFT:
                hornLeft.setSizeHeightAndWidth(1F,5F);
                hornRight.setSizeHeightAndWidth(1F,5F);
                noseRight.setLayout(-16, -6);
                noseLeft.setLayout(-16, 6);
                rightEye.setLayout(0, 12);
                leftEye.setLayout(0, -12);
                hornLeft.setLayout(10, 2);
                hornRight.setLayout(10, -6);
                break;
            case RIGHT:
                hornLeft = new SnakeHorn(1F, 5F);
                hornRight = new SnakeHorn(1F, 5F);
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