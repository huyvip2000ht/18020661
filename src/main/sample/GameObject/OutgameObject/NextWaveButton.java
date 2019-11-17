package main.sample.GameObject.OutgameObject;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.sample.Config;
import main.sample.Main;

import java.awt.*;

public class NextWaveButton extends OutgameObject {

    private Image image;
    public static ImageView imageView;
    private boolean check=false;

    public NextWaveButton(){
        image=new Image("file:src/main/AssetsKit_2/NextWaveButton.png");
        imageView=new ImageView(image);
        imageView.setX(13* Config.SCALE);
        imageView.setY(9*Config.SCALE);
        imageView.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                check=!check;
                Main.spawner.index++;

                Main.spawner.timeCreated=Main.tick.getTime()+1;
            }
        }));

    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(image,13*Config.SCALE,9*Config.SCALE,Config.SCALE,Config.SCALE);

    }

    @Override
    public void update() {

    }
}
