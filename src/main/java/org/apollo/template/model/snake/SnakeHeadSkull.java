package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SnakeHeadSkull extends Group implements Snakeable {
    private Circle body;
    private float size = .3f;

    public SnakeHeadSkull(){
        initialize();
    }

    @Override
    public void rotate(int deg) {
        body.setRotate(deg);
    }

    public SnakeHeadSkull(Float size){
        this.size = size;
        initialize();
    }
    private void initialize(){
        drawBody();
        getChildren().add(body);

    }

    public void drawBody(){
        body = new Circle();
        body.setRadius(25);
        body.setFill(Color.GREEN);
    }
    @Override
    public void setLayout(int x, int y) {
        body.setLayoutX(x);
        body.setLayoutY(y);
    }
}
