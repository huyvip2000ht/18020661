package main.sample.GameObject.IngameObject.Bullet;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

public class SniperBullet extends AbtractBullet {
    Image bulletImg;

    public SniperBullet(int i , int j, double angle, AbtractTower owner){
        this.i=i;
        this.j=j;

        centerI=i+32;
        centerJ=j+32;

        this.owner=owner;

        damage=10;
        speed=25;
        this.angle=angle;

        bulletImg=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile247.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        ImageView imageView=new ImageView(bulletImg);
        SnapshotParameters snapshotParameters=new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.angle,32,32));
        snapshotParameters.setViewport(new Rectangle2D(0,0,64,64));

        Image image=imageView.snapshot(snapshotParameters,null);


        gc.drawImage(image,i,j);
    }
}
