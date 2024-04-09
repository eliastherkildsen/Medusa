package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SnakeBody extends Group implements Snake {
    private Circle body;
    private float size = .3f;

    public SnakeBody(){
        initialize();
    }
    public SnakeBody(Float size){
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
