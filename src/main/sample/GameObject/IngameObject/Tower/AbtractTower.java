package main.sample.GameObject.IngameObject.Tower;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
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

    Image gunImg;
    Image baseImg;
    ImageView gunImgView;
    ImageView hitImgView;
    Image rotatedGun;

    boolean check;



    public List<AbtractBullet> bullets=new ArrayList<>();



   boolean haveTarget(AbtractEnemy enemy){
       if(Point.distance(this.centerI,this.centerJ,enemy.centerI,enemy.centerJ)
               <=this.fireRange* Config.SCALE){
           return true;
       }
       return false;
   }

    public abstract void addBullet();

   public void clickTower(){
       hitImgView.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent mouseEvent) {
               check=!check;
           }
       });
   }

    public void update(){
       for(AbtractEnemy a: spawner.enemies){

               if(this.haveTarget(a)){
                   this.angle= Angle.degree(this.centerI,this.centerJ, a.centerI, a.centerJ);
                   if(tick.getTime()>=timeShot+fireRate) {
                       addBullet();

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
   public void render(GraphicsContext gc){

       SnapshotParameters snapshotParameters=new SnapshotParameters();
       snapshotParameters.setFill(Color.TRANSPARENT);
       snapshotParameters.setTransform(new Rotate(this.angle,32,32));
       snapshotParameters.setViewport(new Rectangle2D(0,0,64,64));



       rotatedGun=gunImgView.snapshot(snapshotParameters,null);

       bullets.forEach(g->g.render(gc));
       if(check) {
           gc.setStroke(Color.GREENYELLOW);
           gc.strokeOval(i - fireRange * Config.SCALE + 32, j - fireRange * Config.SCALE + 32, fireRange * Config.SCALE * 2, fireRange * Config.SCALE * 2);
       }
       gc.drawImage(baseImg,i,j);
       gc.drawImage(rotatedGun,i,j);

   }

    public double getFireRange() {
        return fireRange;
    }
}
