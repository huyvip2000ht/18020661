package main.sample.GameObject.IngameObject.Tower;

import javafx.scene.media.MediaPlayer;
import main.sample.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.sample.GameObject.IngameObject.Bullet.NormalBullet;

public class NormalTower extends AbstractTower {

    private static MediaPlayer mediaPlayer;

    public NormalTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.SCALE;
        j = y * Config.SCALE;
        centerI = x * Config.SCALE + 32;
        centerJ = y * Config.SCALE + 32;
        damage = Config.NORMAL_GUN_DAMAGE;
        fireRate = Config.NORMAL_GUN_FIRE_RATE;
        fireRange = Config.NORMAL_GUN_FIRE_RANGE;
        this.timeShot = 0;
        this.angle = 0;
        value = 300;
        check = false;
        level = 1;

        gunImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        baseImg = new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile181.png");

        gunImgView = new ImageView(gunImg);

        hitImgView = new ImageView(new Image("file:src/main/AssetsKit_2/64x64.png"));

        hitImgView.setX(i);
        hitImgView.setY(j);
        hitImgView.setVisible(true);

        clickTower();
        enterTower();
        exitTower();
        Main.root.getChildren().add(hitImgView);
    }

    @Override
    public String toString() {
        return "NORMAL\n" +
                "Level: " + level + " \n"
                + "Damage: " + Math.round(damage * 100d) / 100d + "\n"
                + "Fire Range: " + Math.round(fireRange * 100d) / 100d + "\n"
                + "Fire Rate: " + Math.round(fireRate * 100d) / 100d
                ;
    }

    @Override
    public void uplevel() {
        super.uplevel();
        if (level == 2) {
            gunImg = new Image("file:src/main/AssetsKit_2/PNG/Updated tower/NormalLV2.png");

        } else if (level == 3) {
            gunImg = new Image("file:src/main/AssetsKit_2/PNG/Updated tower/NormalLV3.png");

        }
        gunImgView = new ImageView(gunImg);
    }

    @Override
    public void addBullet() {
        bullets.add(new NormalBullet(this.i, this.j, this.angle, this));
        mediaPlayer = new MediaPlayer(SoundTrack.normalTowerShotMedia);
        mediaPlayer.play();
    }
}
