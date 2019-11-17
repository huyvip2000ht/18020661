package main.sample.GameObject.OutgameObject;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
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

public class Store extends OutgameObject {

    private  Image normalTower;
    private Image machineGunTower;
    private Image sniperTower;
    private Image sell;

    public static ImageView normal;
    public static ImageView machineGun;
    public static ImageView sniper;
    public static ImageView selling;

    private boolean clickedNormal;
    private boolean clickedMachineGun;
    private boolean clickedSniper;
    private boolean clickedSell;

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    public Store(){
        normalTower=new Image("file:src/main/AssetsKit_2/Normal.png");
        machineGunTower=new Image("file:src/main/AssetsKit_2/MachineGun.png");
        sniperTower=new Image("file:src/main/AssetsKit_2/Sniper.png");
        sell=new Image("file:src/main/AssetsKit_2/$.png");

        normal=new ImageView(normalTower);
        normal.setX(13* Config.SCALE);
        normal.setY(4* Config.SCALE);

        machineGun=new ImageView(machineGunTower);
        machineGun.setX(13*Config.SCALE);
        machineGun.setY(5*Config.SCALE);

        sniper=new ImageView(sniperTower);
        sniper.setX(13*Config.SCALE);
        sniper.setY(6*Config.SCALE);

        selling=new ImageView(sell);
        selling.setX(13*Config.SCALE);
        selling.setY(7*Config.SCALE);

        clickedNormal=false;
        clickedMachineGun=false;
        clickedSniper=false;
        clickedSell=false;


        normal.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {
                if(!clickedNormal) {
                    clickedNormal=true;
                    clickedMachineGun=false;
                    clickedSniper=false;
                    clickedSell=false;
                }
                else clickedNormal=false;
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
            orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();


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
                System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==0 && Config.NORMAL_VALUE <=Main.reward.getReward()) {
                    Map.map_block[newX][newY]=2;
                    Main.reward.setReward(Main.reward.getReward()-Config.NORMAL_VALUE);
                    Main.ingameObjects.add(new NormalTower(newX, newY));
                 //   Map.draw();
                  //  System.out.println("placed");
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);

            }
        }));

        machineGun.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {
                if(!clickedMachineGun) {
                    clickedMachineGun=true;
                    clickedSniper=false;
                    clickedNormal=false;
                    clickedSell=false;
                }
                else clickedMachineGun=false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
             //   System.out.println(t.getX()+" "+t.getY());

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
               // System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==0 && Config.MACHINE_GUN_VALUE <=Main.reward.getReward()) {
                    Map.map_block[newX][newY]=2;
                    Main.reward.setReward(Main.reward.getReward()-Config.MACHINE_GUN_VALUE);
                    Main.ingameObjects.add(new MachineGunTower(newX, newY));
                    //   Map.draw();
                //    System.out.println("placed");
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));
        sniper.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {
                if(!clickedSniper) {
                    clickedSniper=true;
                    clickedMachineGun=false;
                    clickedNormal=false;
                    clickedSell=false;

                }
                else clickedSniper=false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();

            //    System.out.println(event.getX()+" "+event.getY());

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
             //   System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==0 && Config.SNIPER_VALUE <=Main.reward.getReward()) {
                    Map.map_block[newX][newY]=2;
                    Main.reward.setReward(Main.reward.getReward()- Config.SNIPER_VALUE);
                    Main.ingameObjects.add(new SniperTower(newX, newY));
                    //   Map.draw();
              //      System.out.println("placed");
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));
        selling.setOnMousePressed((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if(!clickedSell){
                    clickedSell=true;
                    clickedSniper=false;
                    clickedMachineGun=false;
                    clickedNormal=false;

                }
                else clickedSell=false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
            }
        }));
        selling.setOnMouseDragged((new EventHandler<MouseEvent>() {
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
        selling.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.SCALE);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.SCALE);
             //   System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==2){
                    Map.map_block[newX][newY]=0;
                    for(IngameObject a: Main.ingameObjects){
                        if(a.x==newX&&a.y==newY){
                            Main.reward.setReward(Main.reward.getReward()+((AbtractTower)a).value/3);
                           Main.ingameObjects.remove(a);
                           break;
                        }
                    }
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
        gc.drawImage(sell,13*Config.SCALE,7*Config.SCALE);

        gc.fillText("300$",14* Config.SCALE,4* Config.SCALE +32);
        gc.fillText("500$",14* Config.SCALE,5* Config.SCALE +32);
        gc.fillText("700$",14* Config.SCALE,6* Config.SCALE +32);

        gc.fillText("Wave: "+Main.spawner.index,13* Config.SCALE,11* Config.SCALE);

        gc.setStroke(Color.BLACK);
        if(clickedNormal) gc.strokeRect(13*Config.SCALE,4*Config.SCALE,2*Config.SCALE,Config.SCALE);
        else if(clickedMachineGun) gc.strokeRect(13*Config.SCALE,5*Config.SCALE,2*Config.SCALE,Config.SCALE);
        else if(clickedSniper) gc.strokeRect(13*Config.SCALE,6*Config.SCALE,2*Config.SCALE,Config.SCALE);
        else if(clickedSell) gc.strokeRect(13*Config.SCALE,7*Config.SCALE,Config.SCALE,Config.SCALE);

    }

    @Override
    public void update() {

    }
}
