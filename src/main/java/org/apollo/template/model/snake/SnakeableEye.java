package org.apollo.template.model.snake;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class SnakeableEye extends Group implements Snakeable {

    private Circle iris;
    private Ellipse pubel;
    private Circle eyeApple;
    private Circle eyeAppleBorder;
    private float size = .3f;

    public SnakeableEye() {
        initialize();
    }

    public SnakeableEye(float size) {
        this.size = size;
        initialize();
    }

    @Override
    public void rotate(int deg) {
        iris.setRotate(deg);
        pubel.setRotate(deg);
        eyeApple.setRotate(deg);
        eyeAppleBorder.setRotate(deg);
    }

    private void initialize(){
        drawIris();
        drawPubel();
        drawEyeApple();
        drawEyeAppleBoarder();

        getChildren().addAll(eyeAppleBorder,eyeApple,iris,pubel);
    }

    private void drawEyeAppleBoarder() {
        eyeAppleBorder = new Circle();
        eyeAppleBorder.setFill(Color.BLACK);
        eyeAppleBorder.setRadius(size * 6);
    }

    private void drawIris(){
        iris = new Circle();
        iris.setFill(Color.DARKCYAN);
        iris.setRadius(size * 3);
    }

    private void drawPubel(){
        pubel = new Ellipse();
        pubel.setFill(Color.BLACK);
        pubel.setRadiusX(size * 1);
        pubel.setRadiusY(size * 2);
    }

    private void drawEyeApple(){
        eyeApple = new Circle();
        eyeApple.setFill(Color.WHITE);
        eyeApple.setRadius(size * 5);
    }
    public void setLayout(int x, int y){

        iris.setLayoutX(x);
        iris.setLayoutY(y);

        pubel.setLayoutX(x);
        pubel.setLayoutY(y);

        eyeApple.setLayoutX(x);
        eyeApple.setLayoutY(y);

        eyeAppleBorder.setLayoutX(x);
        eyeAppleBorder.setLayoutY(y);





    }



}
