package main.sample.GameEntity.Tower;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.sample.Main;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class NormalTower extends AbtractTower {
    Image gunImg;

    Image baseImg;

    public NormalTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.scale;
        j = y * Config.scale;
        damage = 1;
        fireRate = 2;
        fireRange = 2;
        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");

    }

    public void render(GraphicsContext gc){
        gc.drawImage(baseImg,i,j);
        gc.drawImage(gunImg,i,j);
    }
    public void update(){

    }
}
