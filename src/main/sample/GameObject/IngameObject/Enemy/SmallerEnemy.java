package main.sample.GameObject.IngameObject.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.sample.Config;
import main.sample.Direction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SmallerEnemy extends AbtractEnemy{
    Image image;

    public SmallerEnemy(int x,int y){
        this.x=x;
        this.y=y;

        image=new Image("file:src/main/kenney_topdowntanksredux/PNG/Default size/tank_blue.png");
        widthImg= (int) image.getWidth();
        heightImg= (int) image.getHeight();

        i = x * Config.SCALE +32;
        j = y * Config.SCALE +32;
        centerI=x*Config.SCALE +32+widthImg/2;
        centerJ=y*Config.SCALE +32+heightImg/2;
        health = Config.SMALLER_HEALTH;
        reward = Config.SMALLER_REWARD;
        speed = Config.SMALLER_SPEED;
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
        gc.setFill(Color.RED);
        gc.fillRect(i,j-5,widthImg,5);
        gc.setFill(Color.GREEN);
        gc.fillRect(i,j-5,(double) (widthImg)*this.health/Config.SMALLER_HEALTH,5);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(i,j-5,widthImg,5);
    }
}
