package main.sample.GameObject.IngameObject.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import main.sample.*;
import javafx.scene.image.Image;

public class NormalEnemy extends AbtractEnemy {

    private Image gunImg;
    private Image baseImg;

  public NormalEnemy(int x,int y){
        this.x=x;
        this.y=y;
      gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile291.png");
      baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile268.png") ;

        i = x * Config.SCALE +32;
        j = y * Config.SCALE +32;


        widthImg= (int) baseImg.getWidth();
        heightImg= (int) baseImg.getHeight();
        centerI=x*Config.SCALE +32+widthImg/2;
        centerJ=y*Config.SCALE +32+heightImg/2;
        health = Config.NORMAL_HEALTH;
        reward = Config.NORMAL_REWARD;
        speed = Config.NORMAL_SPEED;
        direction= Direction.UP;

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
/*
        gc.setFill(Color.BLACK);
        gc.fillOval(i-5, j-5,10, 10);
        gc.setFill(Color.RED);
        gc.fillOval(centerI-5,centerJ-5,10,10);

 */
        gc.setFill(Color.RED);
        gc.fillRect(i,j-5,widthImg,5);


        gc.setFill(Color.GREEN);
        gc.fillRect(i,j-5,(double) (widthImg)*this.health/Config.NORMAL_HEALTH,5);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(i,j-5,widthImg,5);

     //   gc.drawImage(baseImg,i,j);
     //   gc.drawImage(gunImg,i,j);

    }
}
