package main.sample;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;

/**
 * @web http://java-buddy.blogspot.com/
 */
public class test extends Application {

    @Override
    public void start(Stage primaryStage) {

        String musicFile="BackGround.wav";

       // Media pick = new Media(new File(musicFile).toURI().toString());

        Media pick=new Media( new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(pick);
        player.play();

        // Add a mediaView, to display the media. Its necessary !
        // This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);

        // Add to scene
   //     Group root = new Group(mediaView);
    //    Scene scene = new Scene(root, 500, 200);

        // Show the stage
     //   primaryStage.setTitle("Media Player");
    //    primaryStage.setScene(scene);
   //     primaryStage.show();

        // Play the media once the stage is shown


    }

    public static void main(String[] args) {
        launch(args);
    }
}