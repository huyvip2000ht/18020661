package main.sample.GameObject.IngameObject.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import main.sample.*;
import javafx.scene.image.Image;

public class NormalEnemy extends AbtractEnemy {

    Image gunImg;
    Image baseImg;

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


   //     gc.fillOval(i, j,10, 10);

     //   gc.drawImage(baseImg,i,j);
     //   gc.drawImage(gunImg,i,j);

    }
}
