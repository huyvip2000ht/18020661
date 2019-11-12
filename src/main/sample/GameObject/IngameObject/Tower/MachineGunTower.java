package main.sample.GameObject.IngameObject.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.Angle;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Bullet.AbtractBullet;
import main.sample.GameObject.IngameObject.Bullet.MachineGunBullet;
import main.sample.GameObject.IngameObject.Enemy.AbtractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;

import static main.sample.Main.ingameObjects;
import static main.sample.Main.tick;

public class MachineGunTower extends AbtractTower {
    Image gunImg;

    Image baseImg;

    public MachineGunTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.scale;
        j = y * Config.scale;
        centerI=x*Config.scale+32;
        centerJ=y*Config.scale+32;
        damage = 1;
        fireRate = 5;
        fireRange = 3;
        this.timeShot=0;
        this.angle=0;
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
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
                        bullets.add(new MachineGunBullet(this.i, this.j,this.angle,this));
                        timeShot=tick.getTime();

                    }
                    break;
                }
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
        gc.strokeOval(i-fireRange*Config.scale+32,j-fireRange*Config.scale+32,fireRange*Config.scale*2,fireRange*Config.scale*2);
        gc.drawImage(baseImg,i,j);
        gc.drawImage(gun,i,j);
    }
}
