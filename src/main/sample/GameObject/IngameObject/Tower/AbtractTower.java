package main.sample.GameObject.IngameObject.Tower;

import javafx.scene.media.MediaPlayer;
import main.sample.*;
import main.sample.GameObject.IngameObject.Bullet.AbtractBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.Bullet.NormalBullet;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.Point;

import java.util.ArrayList;
import java.util.List;

import static main.sample.Main.*;
import static main.sample.Main.tick;

public abstract class AbtractTower extends IngameObject {

    double  damage;
    double fireRate;
    double fireRange;
    double angle;
    double timeShot;
    public int value;

    public List<AbtractBullet> bullets=new ArrayList<>();

   boolean haveTarget(AbtractEnemy enemy){
       if(Point.distance(this.centerI,this.centerJ,enemy.centerI,enemy.centerJ)
               <=this.fireRange* Config.SCALE){
           return true;
       }
       return false;
   }



    public void update(){
       for(AbtractEnemy a: spawner.enemies){

               if(this.haveTarget(a)){
                   this.angle= Angle.degree(this.centerI,this.centerJ, a.centerI, a.centerJ);
                   if(tick.getTime()>=timeShot+fireRate) {
                       bullets.add(new NormalBullet(this.i, this.j,this.angle,this));

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

    public double getFireRange() {
        return fireRange;
    }
}
