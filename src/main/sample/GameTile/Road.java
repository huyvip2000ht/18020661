package main.sample.GameTile;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;
import main.sample.Config;
import main.sample.Point;

import java.util.ArrayList;
import java.util.List;

public class Road {

    public static final Point[] wayPoints = new Point[] {
            new Point(2 * Config.scale, 11* Config.scale),
            new Point(2 * Config.scale, 6 * Config.scale),
            new Point(6 * Config.scale, 6 * Config.scale),
            new Point(6 * Config.scale, 1 * Config.scale),
            new Point(11* Config.scale, 1 * Config.scale)

    };
    public static void drawPoints(GraphicsContext gc){
        for (int n = 0;n<wayPoints.length;n++){
            Circle circle=new Circle();
            circle.setCenterX( wayPoints[n].getX() );
            circle.setCenterY( wayPoints[n].getY() );
            circle.setRadius(10);
            gc.fillOval(wayPoints[n].getX(),wayPoints[n].getY(),10,10);
        }


    }

}
