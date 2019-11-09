package main.sample.GameEntity.Enemy;

import main.sample.*;
import main.sample.GameEntity.GameEntity;

public abstract class AbtractEnemy extends GameObject implements GameEntity {
  //  Point point;
    int health;
    int reward;
    int speed;
    Direction direction;
   /* public AbtractEnemy(Point point,Direction direction,int health,int reward,int speed,int armor){
        this.point=point;
        this.direction=direction;
        this.health=health;
        this.reward=reward;
        this.speed=speed;

    }*/
}
