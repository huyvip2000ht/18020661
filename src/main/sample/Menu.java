package main.sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.sample.GameObject.OutgameObject.NextWaveButton;
import main.sample.GameObject.OutgameObject.Store;

import java.util.ConcurrentModificationException;

public class Menu {
    public Image image_button = new Image("file:src/main/AssetsKit_2/PlayButton.png");
    public Image image_button_ready = new Image("file:src/main/AssetsKit_2/PlayButton_ready.png");
    public ImageView imageView_button = new ImageView(image_button);
    public Image image_menu = new Image("file:src/main/AssetsKit_2/Menu.png");
    public ImageView imageView_menu = new ImageView(image_menu);

    public void Menu(){


    }
    public void add(){
        imageView_button.setX(Config.WIDTH * Config.SCALE / 2 - 192 / 2);
        imageView_button.setY(Config.HEIGHT * Config.SCALE / 2 - 128 / 2);


        imageView_menu.setFitHeight(Config.HEIGHT * Config.SCALE);
        imageView_menu.setFitWidth(Config.WIDTH * Config.SCALE);

        imageView_button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView_button.setImage(image_button_ready);

            }
        });
        imageView_button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView_button.setImage(image_button);
            }
        });

        Main.root.getChildren().add(imageView_menu);
        Main.root.getChildren().add(imageView_button);
    }
}
