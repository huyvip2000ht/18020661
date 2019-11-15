package main.sample.GameObject.IngameObject.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalTower extends AbtractTower {
    Image gunImg;

    Image baseImg;

    public NormalTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.SCALE;
        j = y * Config.SCALE;
        centerI=x*Config.SCALE +32;
        centerJ=y*Config.SCALE +32;
        damage = Config.NORMAL_GUN_DAMAGE;
        fireRate = Config.NORMAL_GUN_FIRE_RATE;
        fireRange = Config.NORMAL_GUN_FIRE_RANGE;
        this.timeShot=0;
        this.angle=0;
     //   value=300;
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");
    }

    public void render(GraphicsContext gc){
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

        gc.setFill(Color.BLACK);
        gc.fillOval(i-5, j-5,10, 10);
        gc.setFill(Color.RED);
        gc.fillOval(centerI-5,centerJ-5,10,10);
        gc.setFill(Color.BLACK);
    }

}
