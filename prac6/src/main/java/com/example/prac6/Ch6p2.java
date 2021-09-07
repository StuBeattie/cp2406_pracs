package com.example.prac6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
     * A simple demonstration of MouseEvents.  Shapes are drawn
     * on a white background when the user clicks the canvas.  If
     * the user right-clicks, the canvas is cleared.  If the user
     * shift-clicks the canvas, a blue oval is drawn.  Otherwise,
     * when the user clicks, a red rectangle is drawn.  If the user
     * did not right-click, then ovals or rects continue to be
     * drawn as the user drags the mouse.
     */
    public class Ch6p2 extends Application {
        private double xRed;
        private double yRed;
        private double xBlue;
        private double yBlue;

    public Ch6p2() {
    }


    public static void main(String[] args) {
            launch(args);
        }


        /**
         * A graphics context for drawing on the canvas that fills the screen.
         */
        private GraphicsContext canvasGraphics;


        /**
         * This start() method sets up the GUI to show a canvas where the shapes
         * are drawn, and it installs mouse handlers on the canvas to draw shapes
         * as the user presses and drags the mouse.
         */
        public void start(Stage stage) {

            Canvas canvas = new Canvas(500,380);
            canvasGraphics = canvas.getGraphicsContext2D();
            canvasGraphics.setFill(Color.WHITE);
            canvasGraphics.fillRect(0,0,500,380);
            canvasGraphics.setStroke(Color.BLACK); // stroke color never changes
            
            canvas.setOnMouseDragged(this::mouseDragged);

            initMyShapes();

            BorderPane root = new BorderPane(canvas);
            root.setStyle("-fx-border-color: black; -fx-border-width: 2px");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Mouse Drag Demo");
            stage.setResizable(false);
            scene.setOnKeyPressed(this::keyTyped);
            stage.show();

        } // end start()
        private  void keyTyped(KeyEvent e) {
            System.out.println("e.getCode() = " + e.getCode());
            if (e.getCode() == KeyCode.ESCAPE) {
                initMyShapes();
            }
        }

        private void initMyShapes() {
            drawMyShape(xRed, yRed, Color.WHITE);
            drawMyShape(xBlue, yBlue, Color.WHITE);
            xRed = 100;
            yRed = 100;
            xBlue = 200;
            yBlue = 150;
            drawMyShape(xRed, yRed, Color.RED);
            drawMyShape(xBlue, yBlue, Color.BLUE);
        }

        /**
         *  This method is called when the user drags the mouse.  If a the value of the
         *  instance variable dragging is true, it will draw a rect or oval at the
         *  current mouse position.
         */
        public void mouseDragged(MouseEvent evt) {
            double x = evt.getX();  // x-coordinate where user clicked.
            double y = evt.getY();  // y-coordinate where user clicked.

            if (!(Math.abs(x - xRed) > 20) && !(Math.abs(y - yRed) > 20)) {
                drawMyShape(xRed, yRed, Color.WHITE);
                xRed = x;
                yRed = y;
                drawMyShape(x, y, Color.RED);
            }

            if (!(Math.abs(x - xBlue) > 20) && !(Math.abs(y - yBlue) > 20)) {
                drawMyShape(xBlue, yBlue, Color.WHITE);
                xBlue = x;
                yBlue = y;
                drawMyShape(x, y, Color.BLUE);
            }
        } // end mouseDragged();

        private  void drawMyShape(double x, double y, Color myColor){
            canvasGraphics.setFill(myColor);   // Red interior.
            canvasGraphics.fillRect( x - 30, y - 15, 60, 30 );
        }
    } // end class SimpleStamperWithDrag
