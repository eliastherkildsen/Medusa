package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class SnakeNose extends Group implements Snake {
    private Circle nose;
    private Circle noseHole;
    private float size = .3f;
    public SnakeNose () {
        initialize();
    }
    public SnakeNose(Float size){
        this.size = size;
        initialize();
    }

    private void initialize(){
        drawNose();

        getChildren().add(nose);

    }

    public void drawNose(){
        nose = new Circle();
        nose.setRadius(size * 5);
    }
    public void drawNoseHole(){

    }

    public void setLayout(int x, int y){

        nose.setLayoutX(x);
        nose.setLayoutY(y);

    }
}
