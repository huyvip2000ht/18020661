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

    private static String battle= "Battle.mp3";
    public static Media battleMedia=new Media( new File(battle).toURI().toString());
    public static MediaPlayer battleMediaPlayer=new MediaPlayer(battleMedia);

    private static String normalTowerShot="NormalSound.mp3";
    public static Media normalTowerShotMedia=new Media(new File(normalTowerShot).toURI().toString());

    private static String machineGunTowerShot="MachineGunSound.mp3";
    public static Media machineGunTowerShotMedia=new Media(new File(machineGunTowerShot).toURI().toString());

    private static String sniperTowerShot="SniperSound.mp3";
    public static Media sniperTowerShotMedia=new Media(new File(sniperTowerShot).toURI().toString());

    private static String wave="Wave.mp3";
    public static Media waveMedia=new Media(new File(wave).toURI().toString());






    private static String enter="Enter.mp3";
    public static Media enterMedia=new Media(new File(enter).toURI().toString());

    private static String click="Click.mp3";
    public static Media clickMedia=new Media(new File(click).toURI().toString());


    private static String sell="Sell.mp3";
    public static Media sellMedia=new Media(new File(sell).toURI().toString());

    private static String build="Building.mp3";
    public static Media buildMedia=new Media(new File(build).toURI().toString());


    private static String enemyThrough="LooseLife.mp3";
    public static Media enemyThroughMedia= new Media(new File(enemyThrough).toURI().toString());


    private static String gameOver="GameOver.mp3";
    public static Media gameOverMedia=new Media(new File(gameOver).toURI().toString());
    public static MediaPlayer gameOverMediaPlayer=new MediaPlayer(gameOverMedia);



    public void SoundTrack(){

    }

}
