package com.example.prac6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * A program that shows a red square and a blue square that the user
 * can drag with the mouse.   The user can drag the squares off
 * the canvas and drop them.  Pressing the escape key will restore
 * both squares to their original positions.
 */
public class Ch6p3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------------------------------

    private final double SIZE;

    {
        SIZE = 100;
    }

    private int dice1 = 3;
    private int dice2 = 1;
    private final double x1 = SIZE/2;
    private final double y1 = SIZE/2;   // Coords of top-left corner of the red square.
    private final double x2 = SIZE*2;
    private final double y2;   // Coords of top-left corner of the blue square.

    {
        y2 = SIZE * 2;
    }

    private Canvas canvas;  // The canvas where the squares are drawn.

    /**
     *  The start method sets up the GUI.  It adds mouse event handlers to
     *  the canvas to implement dragging.  It adds a key pressed handler
     *  to the scene that will restore the squares to their original
     *  positions when the user presses the escape key.
     */
    public void start(Stage stage) {

        canvas = new Canvas(SIZE*4,SIZE*4);
        draw(); // show squares in original positions

        canvas.setOnMousePressed( e -> mousePressed() );

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Drag the squares!");
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Draw the canvas, showing the squares in their current positions.
     */
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(66,255,14)); // green
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        g.setFill(Color.WHITE);
        g.fillRect(x1, y1, SIZE, SIZE);
        drawDie(g, dice1, x1, y1);

        g.setFill(Color.WHITE);
        g.fillRect(x2, y2, SIZE, SIZE);
        drawDie(g, dice2, x2, y2);
    }

    void  drawDie(GraphicsContext g, int val, double x, double y) {
        if (val < 1 || val > 6) {
            return;
        }
        g.setFill(Color.BLACK);
        double DOT_SIZE = 20.0;
        var DOT_SHIFT = DOT_SIZE / 2;
        x -= DOT_SHIFT;
        y -= DOT_SHIFT;
        switch (val) {
            case 1 -> g.fillOval(x + SIZE / 2, y + SIZE / 2, DOT_SIZE, DOT_SIZE);
            case 2 -> {
                g.fillOval(x + SIZE / 3, y + SIZE / 3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 2 * SIZE / 3, y + 2 * SIZE / 3, DOT_SIZE, DOT_SIZE);
            }
            case 3 -> placeDot(g, x, y, DOT_SIZE);
            case 4 -> {
                g.fillOval(x + SIZE / 3, y + SIZE / 3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 2 * SIZE / 3, y + 2 * SIZE / 3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 1 * SIZE / 3, y + 2 * SIZE / 3, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 2 * SIZE / 3, y + 1 * SIZE / 3, DOT_SIZE, DOT_SIZE);
            }
            case 5 -> {
                placeDot(g, x, y, DOT_SIZE);
                g.fillOval(x + 3 * SIZE / 4, y + SIZE / 4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + SIZE / 4, y + 3 * SIZE / 4, DOT_SIZE, DOT_SIZE);
            }
            case 6 -> {
                g.fillOval(x + SIZE / 4, y + SIZE / 4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + SIZE / 4, y + 2 * SIZE / 4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + SIZE / 4, y + 3 * SIZE / 4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 3 * SIZE / 4, y + SIZE / 4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 3 * SIZE / 4, y + 2 * SIZE / 4, DOT_SIZE, DOT_SIZE);
                g.fillOval(x + 3 * SIZE / 4, y + 3 * SIZE / 4, DOT_SIZE, DOT_SIZE);
            }
        }
    }

    private void placeDot(GraphicsContext g, double x, double y, double DOT_SIZE) {
        g.fillOval(x + SIZE / 4, y + SIZE / 4, DOT_SIZE, DOT_SIZE);
        g.fillOval(x + 2 * SIZE / 4, y + 2 * SIZE / 4, DOT_SIZE, DOT_SIZE);
        g.fillOval(x + 3 * SIZE / 4, y + 3 * SIZE / 4, DOT_SIZE, DOT_SIZE);
    }

    /**
     * Respond when the user presses the mouse on the canvas.
     * Check which square the user clicked, if any, and start
     * dragging that square.
     */
    public void mousePressed() {
        System.out.println("Rolling");
        dice1 = (int)(Math.random()*6) + 1;
        dice2 = (int)(Math.random()*6) + 1;
        draw();
    }

} // end class DragTwoSquares
