package main.sample.GameObject.OutgameObject;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;
import main.sample.Config;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import main.sample.Main;

public class Store extends OutgameObject {

    Image normalTower;
    Image machineGunTower;
    Image sniperTower;
    public static Circle circle=new Circle(100,100,100);

    public Store(){
        normalTower=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        machineGunTower=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        sniperTower=new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile204.png");
        ImageView imageView=new ImageView(normalTower);
        circle.setOnMouseClicked((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                System.out.println("Hello World");

            }
        }));


    }




    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(normalTower,13* Config.scale,4* Config.scale);
        gc.drawImage(machineGunTower,13*Config.scale,5*Config.scale);
        gc.drawImage(sniperTower,13* Config.scale,6* Config.scale);

    }

    @Override
    public void update() {

    }
}
