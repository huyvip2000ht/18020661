package main.sample.GameObject.OutgameObject;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import main.sample.Config;
import main.sample.Main;
import main.sample.SoundTrack;

import java.awt.*;

public class NextWaveButton extends OutgameObject {

    private Image image;
    public static ImageView imageView;
    public Image image_ready;
    private boolean check=false;

    public NextWaveButton(){
        image=new Image("file:src/main/AssetsKit_2/NextWaveButton.png");
        image_ready=new Image("file:src/main/AssetsKit_2/NextWaveButton_ready.png");
        imageView=new ImageView(image);
        imageView.setX(12* Config.SCALE+32);
        imageView.setY(11*Config.SCALE);
        imageView.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                check=!check;
                if(Main.spawner.isHappening());
                else {
                    Main.spawner.index++;
                    Main.spawner.updateTime();
                    MediaPlayer enterMediaPlayer=new MediaPlayer(SoundTrack.waveMedia);
                    enterMediaPlayer.play();
                }

            }
        }));
        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView.setImage(image_ready);
                MediaPlayer enterMediaPlayer=new MediaPlayer(SoundTrack.enterMedia);
                enterMediaPlayer.play();


            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView.setImage(image);
            }
        });

    }

    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update() {

    }
}
