package com.example.prac6;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;


/**
 * Shows a pair of dice that are rolled when a button is clicks
 */
public class Ch6p4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private int die1 = 4;
    private int die2 = 3;
    private Canvas canvas;
    private Button rollButton;
    private int frameNumber;

    private final AnimationTimer timer; // The timer is used to animate "rolling" of the dice.

    {
        timer = new AnimationTimer() {
            public void handle(long time) {
                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                draw();
                frameNumber++;
                if (frameNumber == 30) {
                    timer.stop();
                    rollButton.setDisable(false);
                }
            }
        };
    }

    public void start(Stage stage) { // The start() method sets up the GUI

        canvas = new Canvas(100,100);
        draw();  // Draw the original dice.

        rollButton = new Button("Roll!");
        rollButton.setMaxWidth(1000);  // so button can grow to full width of window
        rollButton.setOnAction( e -> roll() ); // When clicked, roll the dice.

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(rollButton);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dice!");
        stage.setResizable(false);
        stage.show();

    } // end start()

    private void roll() { //Roll the dice by starting an animation when the button is pressed
        frameNumber = 0;
        rollButton.setDisable(true);
        timer.start(); // start the animation
    }


    /**
     * Draw a die with upper left corner at (x,y).  The die is
     * 35 by 35 pixels in size.  The val parameter gives the
     * value showing on the die (that is, the number of dots).
     */
    private void drawDie(GraphicsContext g, int val, int x, int y) {
        g.setFill(Color.WHITE);
        g.fillRect(x, y, 35, 35);
        g.setStroke(Color.BLACK);
        g.strokeRect(x+0.5, y+0.5, 34, 34);
        g.setFill(Color.BLACK);
        if (val > 1)  // upper left dot
            g.fillOval(x+3, y+3, 9, 9);
        if (val > 3)  // upper right dot
            g.fillOval(x+23, y+3, 9, 9);
        if (val == 6) // middle left dot
            g.fillOval(x+3, y+13, 9, 9);
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
            g.fillOval(x+13, y+13, 9, 9);
        if (val == 6) // middle right dot
            g.fillOval(x+23, y+13, 9, 9);
        if (val > 3)  // bottom left dot
            g.fillOval(x+3, y+23, 9, 9);
        if (val > 1)  // bottom right dot
            g.fillOval(x+23, y+23, 9,9);
    }

    /**
     * The draw() method just draws the two dice and draws
     * a two-pixel wide blue border around the canvas.
     */
    private void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.rgb(200,200,255));
        g.fillRect(0,0,100,100);
        g.setStroke( Color.BLUE );
        g.strokeRect(1,1,98,98);
        drawDie(g, die1, 10, 10);
        drawDie(g, die2, 55, 55);
    }

} // end class RollDiceWithButton