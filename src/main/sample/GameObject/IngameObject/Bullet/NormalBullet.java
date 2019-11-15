package main.sample.GameObject.IngameObject.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Bullet.AbtractBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.GameObject;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;
import main.sample.Point;


import static main.sample.Main.ingameObjects;
//import static main.sample.Main.gameObjects;

public class NormalBullet extends AbtractBullet {
    Image bulletImg;

    public NormalBullet(int i ,int j,double angle,AbtractTower owner){
        this.i=i;
        this.j=j;

        centerI=i+32;
        centerJ=j+32;

        this.owner=owner;

        damage=Config.NORMAL_GUN_DAMAGE;
        speed=Config.NORMAL_GUN_SPEED;
        this.angle=angle;

        bulletImg=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile272.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bulletImg,i,j);
    }








}
