package main.sample.GameObject.IngameObject.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import main.sample.Config;
import main.sample.Direction;

public class TankerEnemy extends AbtractEnemy {
    Image image;

    public TankerEnemy(int x,int y){
        this.x=x;
        this.y=y;
        i = x * Config.scale+32;
        j = y * Config.scale+32;
        image=new Image("file:src/main/kenney_topdowntanksredux/PNG/Default size/tank_bigRed.png");
        widthImg= (int) image.getWidth();
        heightImg= (int) image.getHeight();

        centerI=x*Config.scale+32+widthImg/2;
        centerJ=y*Config.scale+32+heightImg/2;
        health = 20;
        reward = 10;
        speed = 2;
        direction= Direction.UP;

    }
    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters snapshotParameters=new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView imageView= new ImageView(image);
        imageView.setRotate(this.direction.getDegree());
        Image rotatedImage=imageView.snapshot(snapshotParameters,null);
        gc.drawImage(rotatedImage,i,j);
        gc.setFill(Color.BLACK);
        gc.fillOval(i-5, j-5,10, 10);
        gc.setFill(Color.RED);
        gc.fillOval(centerI-5,centerJ-5,10,10);
        gc.setFill(Color.BLACK);
    }
}
