package main.sample.GameObject.IngameObject.Bullet;

import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

public abstract class AbtractBullet extends IngameObject {

    public double speed;

    public int damage;
    public double angle;
    public AbtractTower owner;

}
