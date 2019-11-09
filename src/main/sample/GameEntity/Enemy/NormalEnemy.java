package main.sample.GameEntity.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import main.sample.Config;
import javafx.scene.image.Image;
import main.sample.Direction;
import main.sample.GameEntity.Road;
import main.sample.Point;

import java.awt.*;

public class NormalEnemy extends AbtractEnemy {

    Image gunImg;
    Image baseImg;

    int wayPointIndex = 0;
    public main.sample.Point getNextWayPoint() {
        if (wayPointIndex < Road.wayPoints.length - 1)
            return Road.wayPoints[++wayPointIndex];
        return null;
    }



    public NormalEnemy(int x,int y){
        this.x=x;
        this.y=y;
        i = x * Config.scale;
        j = y * Config.scale;
        health = 1;
        reward = 2;
        speed = 10;
        direction= Direction.UP;
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile291.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile268.png") ;
    }


    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters snapshotParameters=new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView gunImgView= new ImageView(gunImg);
        ImageView baseImgView= new ImageView(baseImg);


        gunImgView.setRotate(this.direction.getDegree());
        baseImgView.setRotate(this.direction.getDegree());

        Image base = baseImgView.snapshot(snapshotParameters,null);
        Image gun = gunImgView.snapshot(snapshotParameters,null);





        gc.drawImage(base,i,j);
        gc.drawImage(gun,i,j);


        gc.fillOval(i, j,10, 10);

     //   gc.drawImage(baseImg,i,j);
     //   gc.drawImage(gunImg,i,j);

    }

    void calculateDirection(){
        if (wayPointIndex >= Road.wayPoints.length) {
            // Enemy den way point cuoi
            return;
        }

        Point currentWP = Road.wayPoints[wayPointIndex];
        if (Point.distance(i, j, currentWP.getX(), currentWP.getY()) <= speed) {
            i = currentWP.getX();
            j = currentWP.getY();
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.getX() - i;
            double deltaY = nextWayPoint.getY() - j;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }
    }


    @Override
    public void update() {
        calculateDirection();

        switch (direction) {
            case UP:
                j -= speed;
                break;
            case DOWN:
                j += speed;
                break;
            case LEFT:
                i -= speed;
                break;
            case RIGHT:
                i += speed;
                break;
        }
    }
}
