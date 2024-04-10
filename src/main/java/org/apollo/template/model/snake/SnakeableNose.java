package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class SnakeableNose extends Group implements Snakeable {
    private Circle nose;
    private Circle noseHole;
    private float size = .3f;
    public SnakeableNose() {
        initialize();
    }
    public SnakeableNose(Float size){
        this.size = size;
        initialize();
    }

    @Override
    public void rotate(int deg) {
        nose.setRotate(deg);
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
