package main.sample.GameObject.IngameObject.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.Angle;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Bullet.AbtractBullet;
import main.sample.GameObject.IngameObject.Bullet.MachineGunBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.Main;
import main.sample.SoundTrack;

import static main.sample.Main.*;

public class MachineGunTower extends AbtractTower {

    public MachineGunTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.SCALE;
        j = y * Config.SCALE;
        centerI=x*Config.SCALE +32;
        centerJ=y*Config.SCALE +32;
        damage = Config.MACHINE_GUN_DAMAGE;
        fireRate = Config.MACHINE_GUN_FIRE_RATE;
        fireRange = Config.MACHINE_GUN_FIRE_RANGE;
        this.timeShot=0;
        this.angle=0;
        value=500;
        check=false;
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");

        gunImgView=new ImageView(gunImg);

        hitImgView=new ImageView(new Image("file:src/main/AssetsKit_2/64x64.png"));

        hitImgView.setX(i);
        hitImgView.setY(j);
        hitImgView.setVisible(true);

        clickTower();
        Main.root.getChildren().add(hitImgView);
    }


    @Override
    public void addBullet() {
        bullets.add(new MachineGunBullet(this.i, this.j,this.angle,this));
    }


}
