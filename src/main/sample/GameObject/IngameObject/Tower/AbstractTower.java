package main.sample.GameObject.IngameObject.Tower;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import main.sample.*;
import main.sample.GameObject.IngameObject.Bullet.AbstractBullet;
import main.sample.GameObject.IngameObject.Enemy.AbstractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.OutgameObject.Info;
import main.sample.Point;

import java.util.ArrayList;
import java.util.List;

import static main.sample.Main.*;
import static main.sample.Main.tick;

public abstract class AbstractTower extends IngameObject {

    double damage;
    double fireRate;
    double fireRange;
    double angle;
    double timeShot;
    public int value;
    public int level;

    public Image gunImg;
    public Image baseImg;
    ImageView gunImgView;
    ImageView hitImgView;
    Image rotatedGun;

    boolean check;


    public List<AbstractBullet> bullets = new ArrayList<>();


    public void uplevel() {
        if (level < 3) {
            if (Main.reward.getReward() >= 0.65 * value) {
                level++;
                damage = damage * 1.5;
                fireRate = fireRate / 1.3;
                fireRange = fireRange * 1.1;
                value = (int) (value * 1.3);

                Main.reward.setReward((int) (Main.reward.getReward() - 0.5 * value));
                MediaPlayer mediaPlayer = new MediaPlayer(SoundTrack.buildMedia);
                mediaPlayer.play();
            }

        }

    }

    boolean haveTarget(AbstractEnemy enemy) {
        if (Point.distance(this.centerI, this.centerJ, enemy.centerI, enemy.centerJ)
                <= this.fireRange * Config.SCALE) {
            return true;
        }
        return false;
    }

    public abstract void addBullet();

    public void clickTower() {
        hitImgView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Info.showInfo(AbstractTower.this);


                } catch (IllegalArgumentException e) {
                }
                ;
                //    System.out.println("okoko");
            }
        });
    }

    public void enterTower() {
        hitImgView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                check = true;
                MediaPlayer enterMediaPlayer = new MediaPlayer(SoundTrack.enterMedia);
                enterMediaPlayer.play();
            }
        });
    }

    public void exitTower() {
        hitImgView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                check = false;
            }
        });
    }


    public void update() {
        for (AbstractEnemy a : spawner.enemies) {

            if (this.haveTarget(a)) {
                this.angle = Angle.degree(this.centerI, this.centerJ, a.centerI, a.centerJ);
                if (tick.getTime() >= timeShot + fireRate) {
                    addBullet();

                    timeShot = tick.getTime();

                /*       MediaPlayer x=new MediaPlayer(SoundTrack.towerShotMedia);
                       x.setVolume(0.5);
                       x.play();*/

                }
                break;
            }
        }
        bullets.forEach(AbstractBullet::update);

    }

    public void render(GraphicsContext gc) {

        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.angle, 32, 32));
        snapshotParameters.setViewport(new Rectangle2D(0, 0, 64, 64));


        rotatedGun = gunImgView.snapshot(snapshotParameters, null);

        bullets.forEach(g -> g.render(gc));
        if (check) {
            gc.setStroke(Color.GREENYELLOW);

            gc.strokeOval(i - fireRange * Config.SCALE + 32, j - fireRange * Config.SCALE + 32, fireRange * Config.SCALE * 2, fireRange * Config.SCALE * 2);
        }
        gc.drawImage(baseImg, i, j);
        gc.drawImage(rotatedGun, i, j);

    }

    public double getFireRange() {
        return fireRange;
    }

    public abstract String toString();
}
