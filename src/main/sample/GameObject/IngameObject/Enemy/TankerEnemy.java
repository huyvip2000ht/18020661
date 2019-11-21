package main.sample.GameObject.IngameObject.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import main.sample.Config;
import main.sample.Direction;

public class TankerEnemy extends AbtractEnemy {


    public TankerEnemy(int x,int y){
        this.x=x;
        this.y=y;
        i = x * Config.SCALE +32;
        j = y * Config.SCALE +32;
        image=new Image("file:src/main/kenney_topdowntanksredux/PNG/Default size/tank_bigRed.png");
        imageView = new ImageView(image);
        widthImg= (int) image.getWidth();
        heightImg= (int) image.getHeight();

        centerI=x*Config.SCALE +32+widthImg/2;
        centerJ=y*Config.SCALE +32+heightImg/2;
        health = Config.TANKER_HEALTH;
        reward = Config.TANKER_REWARD;
        speed = Config.TANKER_SPEED;
        direction= Direction.UP;

    }
    @Override
    public void render(GraphicsContext gc) {
       super.render(gc);

        gc.setFill(Color.RED);
        gc.fillRect(i,j-5,widthImg,5);

        gc.setFill(Color.GREEN);
        gc.fillRect(i,j-5,(double)(widthImg)*this.health/Config.TANKER_HEALTH,5);

        gc.setStroke(Color.BLACK);
        gc.strokeRect(i,j-5,widthImg,5);

    }
}
