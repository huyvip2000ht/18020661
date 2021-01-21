package main.sample.GameObject.IngameObject.Bullet;

import javafx.scene.image.Image;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Tower.AbstractTower;
//import static main.sample.Main.gameObjects;

public class NormalBullet extends AbstractBullet {


    public NormalBullet(int i, int j, double angle, AbstractTower owner) {
        this.i = i;
        this.j = j;

        centerI = i + 32;
        centerJ = j + 32;

        this.owner = owner;

        damage = Config.NORMAL_GUN_DAMAGE;
        speed = Config.NORMAL_GUN_SPEED;
        this.angle = angle;


        bulletImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile272.png");
    }

}
