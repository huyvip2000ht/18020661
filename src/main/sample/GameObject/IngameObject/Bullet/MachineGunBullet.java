package main.sample.GameObject.IngameObject.Bullet;

import javafx.scene.image.Image;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Tower.AbstractTower;

import java.util.Random;

public class MachineGunBullet extends AbstractBullet {


    public MachineGunBullet(int i, int j, double angle, AbstractTower owner) {
        this.i = i;
        this.j = j;

        centerI = i + 32;
        centerJ = j + 32;

        this.owner = owner;


        damage = Config.MACHINE_GUN_DAMAGE;
        speed = Config.MACHINE_GUN_SPEED;
        Random random = new Random();
        this.angle = angle + random.nextInt(60) - 30;

        bulletImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile275.png");
    }

}
