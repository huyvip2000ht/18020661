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

        damage=1;
        speed=7;
        this.angle=angle;

        bulletImg=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile272.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bulletImg,i,j);
    }


    public boolean isInHitbox(AbtractEnemy enemy){
        if(centerI<=enemy.i+64 && centerI>=enemy.i
            && centerJ<=enemy.j+64 && centerJ>=enemy.j){
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

            if (a.getClass().getName() == "main.sample.GameObject.IngameObject.Enemy.NormalEnemy") {
                if (this.isInHitbox((AbtractEnemy) a)) {
                  //  System.out.println("Bắn trúng");
                    ((AbtractEnemy) a).health=((AbtractEnemy) a).health-this.damage;


                    owner.bullets.removeIf(s->(s.i==this.i&&s.j==this.j));
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
