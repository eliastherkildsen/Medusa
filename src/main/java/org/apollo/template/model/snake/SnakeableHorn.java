package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class SnakeableHorn extends Group implements Snakeable {
    private Rectangle horn;
    private Rectangle rightHorn;
    private float sizeHeight = .3f;
    private float sizeWidth = .3f;
    public SnakeableHorn() {
        initialize();
    }
    public SnakeableHorn(Float height, Float width){
        this.sizeHeight = height;
        this.sizeWidth = width;
        initialize();
    }
    @Override
    public void rotate(int deg) {
        horn.setRotate(deg);
    }

    private void initialize(){
        drawHorn();

        getChildren().addAll(horn);

    }

    public void drawHorn(){
        horn = new Rectangle();
        horn.setHeight(sizeHeight*3);
        horn.setWidth(sizeWidth*3);
    }

    public void setLayout(int x, int y){

        horn.setLayoutX(x);
        horn.setLayoutY(y);

    }

    public void setSizeHeightAndWidth(float sizeHeight, float sizeWidth) {
        this.sizeHeight = sizeHeight;
        this.sizeWidth = sizeWidth;
    }
}
