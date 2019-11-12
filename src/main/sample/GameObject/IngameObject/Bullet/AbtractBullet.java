package main.sample.GameObject.IngameObject.Bullet;

import main.sample.Config;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;
import main.sample.Point;

import static main.sample.Main.ingameObjects;

public abstract class AbtractBullet extends IngameObject {

    public double speed;

    public int damage;
    public double angle;
    public AbtractTower owner;

    public boolean isInHitbox(AbtractEnemy enemy){
        if(centerI<=enemy.i+enemy.widthImg && centerI>=enemy.i
                && centerJ<=enemy.j+enemy.heightImg && centerJ>=enemy.j){
            return true;
        }
        return false;
    }
    public boolean isOutRange(){
        if(Point.distance(i,j,owner.i,owner.j)+speed>=owner.getFireRange()* Config.scale) return true;
        return false;
    }

    @Override
    public void update() {
        if(this.isOutRange()){
            owner.bullets.remove(this);
        }



        for (IngameObject a : ingameObjects) {

            if (    a.getClass().getName() == "main.sample.GameObject.IngameObject.Enemy.NormalEnemy"||
                    a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.SmallerEnemy"||
                    a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.BossEnemy"||
                    a.getClass().getName()=="main.sample.GameObject.IngameObject.Enemy.TankerEnemy") {
                if (this.isInHitbox((AbtractEnemy) a)) {

                    ((AbtractEnemy) a).health=((AbtractEnemy) a).health-this.damage;
                    owner.bullets.remove(this);

                }
            }
        }

        //  System.out.println(angle);
        if(angle<=90)   {
            i=(int)(i+speed*Math.sin(angle/180*Math.PI));
            j=(int)(j-speed*Math.cos(angle/180*Math.PI));
        }
        else if(angle<=180){
            i=(int)(i+speed*Math.cos((angle-90)/180*Math.PI));
            j=(int)(j+speed*Math.sin((angle-90)/180*Math.PI));
        }
        else if(angle<=270){
            i=(int)(i-speed*Math.sin((angle-180)/180*Math.PI));
            j=(int)(j+speed*Math.cos((angle-180)/180*Math.PI));
        }
        else{
            i=(int)(i-speed*Math.cos((angle-270)/180*Math.PI));
            j=(int)(j-speed*Math.sin((angle-270)/180*Math.PI));
        }


        centerI=i+32;
        centerJ=j+32;


    }



}
