package main.sample.GameObject.OutgameObject;


import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.sample.Main;
import main.sample.Map;


import java.awt.*;

public class Info extends OutgameObject {

    public static AbtractTower owner;
    public static boolean check=false;
    private static Image sellImage=new Image("file:src/main/AssetsKit_2/$.png");
    public static ImageView sellImageView=new ImageView(sellImage);
    public static Image upgradeImage=new Image("file:src/main/AssetsKit_2/Upgrade.png");
    public static ImageView upgradeImageView=new ImageView(upgradeImage);

    public static void showInfo(AbtractTower owner){

        sellImageView.setX(13*Config.SCALE-32);
        sellImageView.setY(10*Config.SCALE);

        upgradeImageView.setX(14*Config.SCALE-32);
        upgradeImageView.setY(10*Config.SCALE);

        upgradeImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                owner.uplevel();
            }
        });

        sellImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                check=false;
                Main.reward.setReward( Main.reward.getReward() + owner.value / 3);
                Map.map_block[owner.x][owner.y]=0;
                Main.ingameObjects.remove(owner);

                Main.root.getChildren().remove(sellImageView);
                Main.root.getChildren().remove(upgradeImageView);
            }
        });

        if(Info.owner==owner) {
            check=false;
            Info.owner=null;
            Main.root.getChildren().remove(sellImageView);
            Main.root.getChildren().remove(upgradeImageView);

        }
        else {
            Info.owner = owner;
            check = true;
            Main.root.getChildren().add(sellImageView);
            Main.root.getChildren().add(upgradeImageView);
        }
    }
    public static void drawInfoCorner(GraphicsContext gc){
        gc.strokeRect(12* Config.SCALE,7*Config.SCALE,4*Config.SCALE,4*Config.SCALE);

    }

    @Override
    public void render(GraphicsContext gc) {
        if(check) {
            drawInfoCorner(gc);
            gc.fillText(owner.toString(), 12 * Config.SCALE+20 , 8 * Config.SCALE-32);
            gc.drawImage(owner.baseImg,15*Config.SCALE,7*Config.SCALE+32);
            gc.drawImage(owner.gunImg,15*Config.SCALE,7*Config.SCALE+32);

        }

    }

    @Override
    public void update() {

    }
}
