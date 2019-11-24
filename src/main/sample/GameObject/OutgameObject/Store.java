package main.sample.GameObject.OutgameObject;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import main.sample.Config;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;
import main.sample.GameObject.IngameObject.Tower.MachineGunTower;
import main.sample.GameObject.IngameObject.Tower.NormalTower;
import main.sample.GameObject.IngameObject.Tower.SniperTower;
import main.sample.Main;
import main.sample.Map;
import main.sample.SoundTrack;

public class Store extends OutgameObject {

    private  Image normalTower;
    private Image machineGunTower;
    private Image sniperTower;


    public static ImageView normal;
    public static ImageView machineGun;
    public static ImageView sniper;


    private boolean clickedNormal;
    private boolean clickedMachineGun;
    private boolean clickedSniper;

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;
    private static MediaPlayer enterMediaPlayer;

    public Store(){
        normalTower=new Image("file:src/main/AssetsKit_2/Normal.png");
        machineGunTower=new Image("file:src/main/AssetsKit_2/MachineGun.png");
        sniperTower=new Image("file:src/main/AssetsKit_2/Sniper.png");

        normal=new ImageView(normalTower);
        normal.setX(13* Config.SCALE);
        normal.setY(4* Config.SCALE);

        machineGun=new ImageView(machineGunTower);
        machineGun.setX(13*Config.SCALE);
        machineGun.setY(5*Config.SCALE);

        sniper=new ImageView(sniperTower);
        sniper.setX(13*Config.SCALE);
        sniper.setY(6*Config.SCALE);


        clickedNormal=false;
        clickedMachineGun=false;
        clickedSniper=false;


        normal.setOnMouseEntered((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedNormal=true;

            }
        }));
        normal.setOnMouseExited((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedNormal=false;
            }
        }));
        normal.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
            orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
                enterMediaPlayer=new MediaPlayer(SoundTrack.enterMedia);
                enterMediaPlayer.play();

        }
        }));
        normal.setOnMouseDragged((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
                ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
            }
        }));
        normal.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {


                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.SCALE);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.SCALE);

                if(Map.map_block[newX][newY]==0 && Config.NORMAL_VALUE <=Main.reward.getReward()) {
                    Map.map_block[newX][newY]=2;
                    Main.reward.setReward(Main.reward.getReward()-Config.NORMAL_VALUE);
                    Main.ingameObjects.add(new NormalTower(newX, newY));

                    MediaPlayer mediaPlayer=new MediaPlayer(SoundTrack.buildMedia);
                    mediaPlayer.play();
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);

            }
        }));

        machineGun.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedMachineGun=true;

            }
        });
        machineGun.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedMachineGun=false;
            }
        });
        machineGun.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
                enterMediaPlayer=new MediaPlayer(SoundTrack.enterMedia);
                enterMediaPlayer.play();

            }
        }));

        machineGun.setOnMouseDragged((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
                ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
            }
        }));
        machineGun.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.SCALE);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.SCALE);

                if(Map.map_block[newX][newY]==0 && Config.MACHINE_GUN_VALUE <=Main.reward.getReward()) {
                    Map.map_block[newX][newY]=2;
                    Main.reward.setReward(Main.reward.getReward()-Config.MACHINE_GUN_VALUE);
                    Main.ingameObjects.add(new MachineGunTower(newX, newY));

                    MediaPlayer mediaPlayer=new MediaPlayer(SoundTrack.buildMedia);
                    mediaPlayer.play();

                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));
        sniper.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedSniper=true;

            }
        });
        sniper.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickedSniper=false;
            }
        });

        sniper.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {

                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
                enterMediaPlayer=new MediaPlayer(SoundTrack.enterMedia);
                enterMediaPlayer.play();

            }
        }));
        sniper.setOnMouseDragged((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
                ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
            }
        }));
        sniper.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.SCALE);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.SCALE);
                if(Map.map_block[newX][newY]==0 && Config.SNIPER_VALUE <=Main.reward.getReward()) {
                    Map.map_block[newX][newY]=2;
                    Main.reward.setReward(Main.reward.getReward()- Config.SNIPER_VALUE);
                    Main.ingameObjects.add(new SniperTower(newX, newY));

                    MediaPlayer mediaPlayer=new MediaPlayer(SoundTrack.buildMedia);
                    mediaPlayer.play();

                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));

    }




    @Override
    public void render(GraphicsContext gc) {



        gc.drawImage(normalTower,13* Config.SCALE,4* Config.SCALE);
        gc.drawImage(machineGunTower,13*Config.SCALE,5*Config.SCALE);
        gc.drawImage(sniperTower,13* Config.SCALE,6* Config.SCALE);


        gc.setFill(Color.BLACK);
        gc.fillText("300$",14* Config.SCALE,4* Config.SCALE +32);
        gc.fillText("500$",14* Config.SCALE,5* Config.SCALE +32);
        gc.fillText("700$",14* Config.SCALE,6* Config.SCALE +32);

        gc.fillText("Wave: "+Main.spawner.index,13* Config.SCALE+40,11* Config.SCALE+40);

        gc.setStroke(Color.BLACK);
        if(clickedNormal) gc.strokeRect(13*Config.SCALE,4*Config.SCALE,2*Config.SCALE,Config.SCALE);
        else if(clickedMachineGun) gc.strokeRect(13*Config.SCALE,5*Config.SCALE,2*Config.SCALE,Config.SCALE);
        else if(clickedSniper) gc.strokeRect(13*Config.SCALE,6*Config.SCALE,2*Config.SCALE,Config.SCALE);


    }

    @Override
    public void update() {

    }
}
