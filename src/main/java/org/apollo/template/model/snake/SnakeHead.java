package org.apollo.template.model.snake;

import javafx.scene.layout.Pane;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Direction;

public class SnakeHead extends Pane {
    private final float CONSTANTSIZE = 1F;
    private SnakeableEye rightEye = new SnakeableEye(2f * CONSTANTSIZE);
    private SnakeableEye leftEye = new SnakeableEye(2f * CONSTANTSIZE);
    private SnakeableNose noseLeft = new SnakeableNose(0.5F * CONSTANTSIZE);
    private SnakeableNose noseRight = new SnakeableNose(0.5F * CONSTANTSIZE);
    private SnakeHeadSkull snakeHead = new SnakeHeadSkull(2F * CONSTANTSIZE);
    private Direction directionNow;

    public SnakeHead(Direction direction) {
        DebugMessage.info(this.getClass().getSimpleName(),"Creating Snakeable Head");
        changeHeadRotation(direction);
        directionNow = direction;
        getChildren().addAll(snakeHead, noseLeft, noseRight, rightEye, leftEye);
    }

    /**
     *
     * @param direction
     */
    public void changeHeadRotation(Direction direction){
        if (directionNow == direction){
            return;
        }
        directionNow = direction;
        switch (direction) {
            case UP:
                noseRight.setLayout(-6, -16);
                noseLeft.setLayout(6, -16);
                rightEye.setLayout(12, 0);
                leftEye.setLayout(-12, 0);
                break;
            case DOWN:
                noseRight.setLayout(6, 16);
                noseLeft.setLayout(-6, 16);
                rightEye.setLayout(-12, 0);
                leftEye.setLayout(12, 0);
                break;
            case LEFT:
                noseRight.setLayout(-16, -6);
                noseLeft.setLayout(-16, 6);
                rightEye.setLayout(0, 12);
                leftEye.setLayout(0, -12);
                break;
            case RIGHT:
                noseRight.setLayout(16, 6);
                noseLeft.setLayout(16, -6);
                rightEye.setLayout(0, -12);
                leftEye.setLayout(0, 12);
                break;
        }
        snakeHead.setLayout(0,0);
    }

    public Direction getDirectionNow() {
        return directionNow;
    }
}