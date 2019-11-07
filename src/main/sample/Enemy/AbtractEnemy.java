package main.sample.Enemy;

import main.sample.*;

public abstract class AbtractEnemy extends GameObject implements GameEntity {
    Point point;
    int health;
    int reward;
    int speed;
    int armor;
    Direction direction;
    public AbtractEnemy(Point point,Direction direction,int health,int reward,int speed,int armor){
        this.point=point;
        this.direction=direction;
        this.health=health;
        this.reward=reward;
        this.speed=speed;
        this.armor=armor;
    }
}
