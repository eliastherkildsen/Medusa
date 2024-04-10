package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SnakeableBody extends Group implements Snakeable {
    private Circle body;
    private float size = .3f;

    public SnakeableBody(){
        initialize();
    }

    @Override
    public void rotate(int deg) {
        body.setRotate(deg);
    }

    public SnakeableBody(Float size){
        this.size = size;
        initialize();
    }
    private void initialize(){
        drawBody();
        getChildren().add(body);

    }

    public void drawBody(){
        body = new Circle();
        body.setRadius(size * 10);
        body.setFill(Color.GREEN);
    }
    @Override
    public void setLayout(int x, int y) {
        body.setLayoutX(x);
        body.setLayoutY(y);
    }
}
