package main.sample.GameEntity.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.*;
import main.sample.GameEntity.Enemy.AbtractEnemy;
import main.sample.GameEntity.Tower.Bullet.NormalBullet;
import main.sample.Point;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import static main.sample.Main.*;
import static main.sample.Main.tick;

public abstract class AbtractTower extends GameObject {

    public double  damage;
    public double fireRate;
    public double fireRange;
  //  Circle circle;
    public double angle;
    public double timeShot;



   /* public AbtractTower(int x,int y,double damage,double fireRate,double fireRange,Image gunImg,Image baseImg){
        this.x=x;
        this.y=y;
        this.damage=damage;
        this.fireRate=fireRate;
        this.fireRange=fireRange;
        this.gunImg=gunImg;
        this.baseImg=baseImg;
    }*/

   public boolean haveTarget(AbtractEnemy enemy){
       if(Point.distance(this.centerI,this.centerJ,enemy.centerI,enemy.centerJ)
               <=this.fireRange* Config.scale){
           return true;
       }
       return false;
   }
   public void update(){
       for(GameObject a:gameObjects){

           if(a.getClass().getName()=="main.sample.GameEntity.Enemy.NormalEnemy"){
               if(this.haveTarget((AbtractEnemy)a)){
                   this.angle= Angle.degree(this.centerI,this.centerJ,a.centerI,a.centerJ);
                 //  System.out.println(this.angle);
                   if(tick.getTime()>=timeShot+fireRate) {
                       bullets.add(new NormalBullet(this.i, this.j, a.i, a.j,this.angle));
                       timeShot=tick.getTime();

                   }



                   //     System.out.println(angle);
                   break;
               }





           }
       }



   }


}
