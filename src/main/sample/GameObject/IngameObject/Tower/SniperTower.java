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
import main.sample.GameObject.IngameObject.Bullet.SniperBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.SoundTrack;

import static main.sample.Main.*;

public class SniperTower extends AbtractTower {
    Image gunImg;

    Image baseImg;

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
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile204.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
    }

    public void update(){
        for(AbtractEnemy a:spawner.enemies){
                if(this.haveTarget((AbtractEnemy)a)){
                    this.angle= Angle.degree(this.centerI,this.centerJ,((AbtractEnemy) a).centerI,((AbtractEnemy) a).centerJ);
                    if(tick.getTime()>=timeShot+fireRate) {
                        bullets.add(new SniperBullet(this.i, this.j,this.angle,this));
                        timeShot=tick.getTime();
                        MediaPlayer x=new MediaPlayer(SoundTrack.towerShotMedia);
                        x.setVolume(0.5);
                        x.play();
                    }
                    break;
            }
        }
        bullets.forEach(AbtractBullet::update);

    }



    @Override
    public void render(GraphicsContext gc) {
        ImageView gunImgView=new ImageView(gunImg);
        SnapshotParameters snapshotParameters=new SnapshotParameters();


        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.angle,32,32));
        snapshotParameters.setViewport(new Rectangle2D(0,0,64,64));


        Image gun=gunImgView.snapshot(snapshotParameters,null);

        bullets.forEach(g->g.render(gc));
        gc.setStroke(Color.GREENYELLOW);
        gc.strokeOval(i-fireRange*Config.SCALE +32,j-fireRange*Config.SCALE +32,fireRange*Config.SCALE *2,fireRange*Config.SCALE *2);
        gc.drawImage(baseImg,i,j);
        gc.drawImage(gun,i,j);
    }
}
