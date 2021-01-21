package main.sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

public class Road {

    public static final Point[] wayPoints = new Point[]{
            //    new Point(2 * Config.scale, 12* Config.scale-3),
            new Point(2 * Config.SCALE + 32, 6 * Config.SCALE + 32),
            new Point(6 * Config.SCALE + 32, 6 * Config.SCALE + 32),
            new Point(6 * Config.SCALE + 32, 1 * Config.SCALE + 32),
            new Point(12 * Config.SCALE, 1 * Config.SCALE + 32),
            new Point(12 * Config.SCALE, 1 * Config.SCALE + 32),

    };

    public static void drawPoints(GraphicsContext gc) {
        for (int n = 0; n < wayPoints.length; n++) {
            Circle circle = new Circle();
            circle.setCenterX(wayPoints[n].getX());
            circle.setCenterY(wayPoints[n].getY());
            circle.setRadius(10);
            gc.fillOval(wayPoints[n].getX(), wayPoints[n].getY(), 10, 10);
        }


    }

}
