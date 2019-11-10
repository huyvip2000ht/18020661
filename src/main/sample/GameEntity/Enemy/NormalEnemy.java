package main.sample.GameEntity.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import main.sample.*;
import javafx.scene.image.Image;
import main.sample.GameEntity.Road;
import main.sample.GameEntity.Tower.AbtractTower;
import main.sample.Point;

import java.awt.*;
import java.util.ListIterator;

import static main.sample.Main.gameObjects;

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
        i = x * Config.scale+32;
        j = y * Config.scale+32;
        centerI=x*Config.scale;
        centerJ=y*Config.scale;
        health = 5;
        reward = 2;
        speed = 7;
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
    public boolean isInRange(AbtractTower tower){
        if (Point.distance(this.centerI,this.centerJ,tower.centerI,tower.centerJ)
                <=tower.fireRange*Config.scale){
            return true;
        }
        return false;
    }


    void calculateDirection(){
        if (wayPointIndex >= Road.wayPoints.length-1) {
            // Enemy den way point cuoi
            Main.lives.setLives(Main.lives.getLives()-1);
            gameObjects.remove(this);

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

    /*    ListIterator<GameObject> listIterator=gameObjects.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getClass().getName()=="main.sample.GameEntity.Tower.NormalTower"){
                if(this.isInRange(listIterator.next().)) System.out.println();
            }
        }*/
    if(this.health<=0) {
        Main.reward.setReward(Main.reward.getReward()+this.reward);
        gameObjects.remove(this);
    }

    for(GameObject a:gameObjects){

        if(a.getClass().getName()=="main.sample.GameEntity.Tower.NormalTower"){
            if(this.isInRange((AbtractTower) a));
            //    System.out.println("Trong tầm");
           // System.out.println(Point.distance(this.centerI,this.centerJ,a.centerI,a.centerJ));
        /*    System.out.println("i enemy:"+centerI);
            System.out.println("j enemy:"+centerJ);
            System.out.println("i tower:"+a.centerI);
            System.out.println("j tower"+a.centerJ);*/
        }


    }


        calculateDirection();

        switch (direction) {
            case UP:
                j -= speed;
                centerJ-=speed;
                break;
            case DOWN:
                j += speed;
                centerJ+=speed;
                break;
            case LEFT:
                i -= speed;
                centerI-=speed;
                break;
            case RIGHT:
                i += speed;
                centerI+=speed;
                break;
        }
    }



}
