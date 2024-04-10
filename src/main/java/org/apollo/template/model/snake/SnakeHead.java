package org.apollo.template.model.snake;

import javafx.scene.layout.Pane;
import org.apollo.template.Service.Debugger.DebugMessage;
import org.apollo.template.model.Direction;

public class SnakeHead extends Pane {
    private SnakeableEye rightEye = new SnakeableEye(2f);
    private SnakeableEye leftEye = new SnakeableEye(2f);
    private SnakeableNose noseLeft = new SnakeableNose(0.5F);
    private SnakeableNose noseRight = new SnakeableNose(0.5F);
    private SnakeableHorn hornLeft = new SnakeableHorn(5F,1F);
    private SnakeableHorn hornRight = new SnakeableHorn(5F,1F);
    private SnakeableBody snakeHead = new SnakeableBody(2F);
    private Direction directionNow;

    public SnakeHead(Direction direction) {
        DebugMessage.info(this.getClass().getSimpleName(),"Creating Snakeable Head");
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
        DebugMessage.info("SnakeHead - changeHeadRotation","Setting Snakeable Head direction: " + direction);
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
                hornLeft = new SnakeableHorn(1F, 5F);
                hornRight = new SnakeableHorn(1F, 5F);
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