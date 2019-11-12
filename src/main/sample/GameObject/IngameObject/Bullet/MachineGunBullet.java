package main.sample.GameObject.IngameObject.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

import java.util.Random;

public class MachineGunBullet extends AbtractBullet {

    Image bulletImg;

    public MachineGunBullet(int i , int j, double angle, AbtractTower owner){
        this.i=i;
        this.j=j;

        centerI=i+32;
        centerJ=j+32;

        this.owner=owner;

        damage=1;
        speed=5;
        Random random=new Random();
        this.angle=angle+random.nextInt(60)-30;

        bulletImg=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile275.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bulletImg,i,j);
    }
}