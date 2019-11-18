package main.sample;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;

import java.io.File;

public class SoundTrack {
    private static String background= "BackGround.mp3";
    public static Media backgroundMedia=new Media( new File(background).toURI().toString());
    public static MediaPlayer backgroundMediaPlayer=new MediaPlayer(backgroundMedia);

    private static String towerShot="gunsound.mp3";
    public static Media towerShotMedia=new Media(new File(towerShot).toURI().toString());
//    public static MediaPlayer towerShotMediaPlayer=new MediaPlayer(towerShotMedia);




 /*   private static String enemyHit=".........wav";
    private static Media enemyHitMedia=new Media( new File(enemyHit).toURI().toString());
    public static MediaPlayer enemyHitMediaPlayer=new MediaPlayer(enemyHitMedia);
*/
    private static String enemyThrough="Bruh.mp3";
    public static Media enemyThroughMedia= new Media(new File(enemyThrough).toURI().toString());
//    public static MediaPlayer enemyThroughMediaPlayer=new MediaPlayer(enemyThroughMedia);

    private static String gameOver="GameOver.mp3";
    public static Media gameOverMedia=new Media(new File(gameOver).toURI().toString());
    public static MediaPlayer gameOverMediaPlayer=new MediaPlayer(gameOverMedia);



    public void SoundTrack(){

    }

}
