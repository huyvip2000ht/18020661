package main.sample.GameEntity.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.sample.GameEntity.Enemy.AbtractEnemy;
import main.sample.Point;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static main.sample.Main.gameObjects;

public class NormalTower extends AbtractTower {
    Image gunImg;

    Image baseImg;

    public NormalTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.scale;
        j = y * Config.scale;
        centerI=x*Config.scale-32;
        centerJ=y*Config.scale-32;
        damage = 1;
        fireRate = 2;
        fireRange = 2.6;
        this.angle=0;
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
 /*       this.circle.setI(i);
        this.circle.setJ(j);
        this.circle.setRange(fireRange*Config.scale);*/

    }



    public void render(GraphicsContext gc){
        ImageView gunImgView=new ImageView(gunImg);
        SnapshotParameters snapshotParameters=new SnapshotParameters();
     //   gunImgView.setRotate(this.angle);

        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.angle,32,32));
        snapshotParameters.setViewport(new Rectangle2D(0,0,64,64));
       // Rotate rotate = new Rotate(this.angle,32,32);

        Image gun=gunImgView.snapshot(snapshotParameters,null);



        gc.fillOval(i-fireRange*Config.scale+32,j-fireRange*Config.scale+32,fireRange*Config.scale*2,fireRange*Config.scale*2);
        gc.drawImage(baseImg,i,j);
        gc.drawImage(gun,i,j);
    }
    public boolean haveTarget(AbtractEnemy enemy){
        if(Point.distance(this.centerI,this.centerJ,enemy.centerI,enemy.centerJ)
            <=this.fireRange*Config.scale){
            return true;
        }
        return false;
    }


    public void update(){
        for(GameObject a:gameObjects){

            if(a.getClass().getName()=="main.sample.GameEntity.Enemy.NormalEnemy"){
                if(this.haveTarget((AbtractEnemy)a)){
                    this.angle= Angle.degree(this.centerI,this.centerJ,a.centerI,a.centerJ);
                    System.out.println(angle);
                }

            }
        }



    }


}
