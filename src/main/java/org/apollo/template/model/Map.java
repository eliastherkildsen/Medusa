package org.apollo.template.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Map {
    private Rectangle[][] squares;
    private Color lineColor = Color.rgb (118,150,56);
    public void drawBackground(Pane pane, double paneWidth, double paneHeight, double squareSize) {
        int rows = (int) (paneHeight / squareSize);
        int columns = (int) (paneWidth / squareSize);
        squares = new Rectangle[rows][columns];
        //Draw squares
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Rectangle square = new Rectangle(squareSize, squareSize);
                if ((i + j) % 2 == 0) {
                    square.setFill(Color.rgb(179,215,81));
                } else {
                    square.setFill(Color.rgb(162,209,73));
                }
                square.setX(j * squareSize);
                square.setY(i * squareSize);
                pane.getChildren().add(square);

                squares[i][j] = square;
            }
        }
        // Draw grid lines
        for (int i = 0; i < rows + 1; i++) {
            Line line = new Line(0, i * squareSize, paneWidth, i * squareSize);
            line.setStroke(lineColor);
            pane.getChildren().add(line);
        }

        for (int j = 0; j < columns + 1; j++) {
            Line line = new Line(j * squareSize, 0, j * squareSize, paneHeight);
            line.setStroke(lineColor);
            pane.getChildren().add(line);
        }
    }
    public Rectangle[][] getSquares() {
        return squares;
    }


}
