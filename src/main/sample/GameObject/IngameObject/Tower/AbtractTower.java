package main.sample.GameObject.IngameObject.Tower;

import main.sample.*;
import main.sample.GameObject.IngameObject.Bullet.AbtractBullet;
import main.sample.GameObject.IngameObject.Bullet.MachineGunBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.Bullet.NormalBullet;
import main.sample.GameObject.GameObject;
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
    public List<AbtractBullet> bullets=new ArrayList<>();

   public boolean haveTarget(AbtractEnemy enemy){
       if(Point.distance(this.centerI,this.centerJ,enemy.centerI,enemy.centerJ)
               <=this.fireRange* Config.scale){
           return true;
       }
       return false;
   }

   public void update(){
       for(IngameObject a:ingameObjects){

           if(     a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.NormalEnemy"||
                   a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.SmallerEnemy"||
                   a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.BossEnemy"||
                   a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.TankerEnemy"){
               if(this.haveTarget((AbtractEnemy)a)){
                   this.angle= Angle.degree(this.centerI,this.centerJ,((AbtractEnemy) a).centerI,((AbtractEnemy) a).centerJ);
                   if(tick.getTime()>=timeShot+fireRate) {
                       bullets.add(new NormalBullet(this.i, this.j,this.angle,this));
                       timeShot=tick.getTime();

                   }
                   break;
               }
           }
       }
       bullets.forEach(AbtractBullet::update);

   }

    public double getFireRange() {
        return fireRange;
    }
}
