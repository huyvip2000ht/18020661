package main.sample.GameEntity.Tower.Bullet;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.sample.GameEntity.Enemy.AbtractEnemy;
import main.sample.GameEntity.Tower.AbtractTower;
import main.sample.GameObject;

import static main.sample.Main.bullets;
import static main.sample.Main.gameObjects;

public class NormalBullet extends AbtractBullet{
    Image bulletImg;

    public NormalBullet(int i ,int j,int desI,int desJ,double angle){
        this.i=i;
        this.j=j;
        this.desI=desI;
        this.desJ=desJ;
        centerI=i+32;
        centerJ=j+32;
        centerDesI=desI+32;
        centerDesJ=desJ+32;
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


    @Override
    public void update() {


        for (GameObject a : gameObjects) {

            if (a.getClass().getName() == "main.sample.GameEntity.Enemy.NormalEnemy") {
                if (this.isInHitbox((AbtractEnemy) a)) {
                    System.out.println("Bắn trúng");
                    ((AbtractEnemy) a).health=((AbtractEnemy) a).health-this.damage;




                 /*   for(Iterator<AbtractBullet> iterator=bullets.iterator();iterator.hasNext();){
                        AbtractBullet bullet=iterator.next();
                        if(bullet.i==this.i&&bullet.j==this.j)
                            iterator.remove();;
                    }*/
                    bullets.removeIf(s->(s.i==this.i&&s.j==this.j));
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
