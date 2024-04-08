package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class SnakeHorn extends Group implements Snake {
    private Rectangle horn;
    private Rectangle rightHorn;
    private float size = .3f;
    public SnakeHorn() {
        initialize();
    }
    public SnakeHorn(Float size){
        this.size = size;
        initialize();
    }

    private void initialize(){
        drawHorn();

        getChildren().addAll(horn);

    }

    public void drawHorn(){
        horn = new Rectangle();
        horn.setHeight(size*3);
        horn.setWidth(size);
    }

    public void setLayout(int x, int y){

        horn.setLayoutX(x);
        horn.setLayoutY(y);

    }
}
