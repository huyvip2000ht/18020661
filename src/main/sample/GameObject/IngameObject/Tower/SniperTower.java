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
import main.sample.GameObject.IngameObject.Bullet.SniperBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.Main;
import main.sample.SoundTrack;

import static main.sample.Main.*;

public class SniperTower extends AbtractTower {

    private static MediaPlayer mediaPlayer;

    public SniperTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.SCALE;
        j = y * Config.SCALE;
        centerI=x*Config.SCALE +32;
        centerJ=y*Config.SCALE +32;
        damage = Config.SNIPER_GUN_DAMAGE;
        fireRate = Config.SNIPER_GUN_FIRE_RATE;
        fireRange = Config.SNIPER_GUN_FIRE_RANGE;
        this.timeShot=0;
        this.angle=0;
        value=700;
        check=false;
        level=1;

        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile204.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");

        gunImgView=new ImageView(gunImg);

        hitImgView=new ImageView(new Image("file:src/main/AssetsKit_2/64x64.png"));

        hitImgView.setX(i);
        hitImgView.setY(j);
        hitImgView.setVisible(true);

        clickTower();
        enterTower();
        exitTower();
        Main.root.getChildren().add(hitImgView);
    }

    @Override
    public void uplevel() {
        super.uplevel();
        if(level==2){
            gunImg=new Image("file:src/main/AssetsKit_2/PNG/Updated tower/SniperLV2.png");

        }
        else if(level==3){
            gunImg=new Image("file:src/main/AssetsKit_2/PNG/Updated tower/SniperLV3.png");

        }
            gunImgView=new ImageView(gunImg);
    }

    @Override
    public String toString() {
        return   "SNIPER\n" +
                "Level: "+level+" \n"
                +"Damage: "+Math.round(damage*100d)/100d +"\n"
                +"Fire Range: "+Math.round(fireRange*100d)/100d+"\n"
                +"Fire Rate: "+Math.round(fireRate*100d)/100d
                ;
    }

    @Override
    public void addBullet() {
        bullets.add(new SniperBullet(this.i, this.j,this.angle,this));
        mediaPlayer=new MediaPlayer(SoundTrack.sniperTowerShotMedia);
        mediaPlayer.play();
    }

}
