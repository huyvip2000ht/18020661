package main.sample.GameObject.IngameObject.Bullet;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Enemy.AbstractEnemy;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbstractTower;
import main.sample.Point;
import javafx.scene.image.Image;

import static main.sample.Main.spawner;

public abstract class AbstractBullet extends IngameObject {

    double speed;

    double damage;
    double angle;
    AbstractTower owner;
    Image bulletImg;

    public boolean isInHitbox(AbstractEnemy enemy) {
        if (centerI <= enemy.i + enemy.widthImg && centerI >= enemy.i
                && centerJ <= enemy.j + enemy.heightImg && centerJ >= enemy.j) {
            return true;
        }
        return false;
    }

    public boolean isOutRange() {
        return Point.distance(i, j, owner.i, owner.j) + speed >= owner.getFireRange() * Config.SCALE;
    }

    @Override
    public void update() {
        if (this.isOutRange()) {
            owner.bullets.remove(this);
        }


        for (AbstractEnemy a : spawner.enemies) {

            if (this.isInHitbox(a)) {

                a.health = a.health - this.damage;

                owner.bullets.remove(this);
                break;
            }
            //   }

        }

        //  System.out.println(angle);


        if (angle <= 90) {
            i = (int) (i + speed * Math.sin(angle / 180 * Math.PI));
            j = (int) (j - speed * Math.cos(angle / 180 * Math.PI));
        } else if (angle <= 180) {
            i = (int) (i + speed * Math.cos((angle - 90) / 180 * Math.PI));
            j = (int) (j + speed * Math.sin((angle - 90) / 180 * Math.PI));
        } else if (angle <= 270) {
            i = (int) (i - speed * Math.sin((angle - 180) / 180 * Math.PI));
            j = (int) (j + speed * Math.cos((angle - 180) / 180 * Math.PI));
        } else {
            i = (int) (i - speed * Math.cos((angle - 270) / 180 * Math.PI));
            j = (int) (j - speed * Math.sin((angle - 270) / 180 * Math.PI));
        }

        //    i=(int)(i+speed* Angle.transX(angle));
        //    j=(int)(j+speed* Angle.transY(angle));
        centerI = i + 32;
        centerJ = j + 32;


    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bulletImg, i, j);
    }


}
