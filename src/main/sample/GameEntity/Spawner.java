package main.sample.GameEntity;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;
import main.sample.GameEntity.Enemy.AbtractEnemy;
import main.sample.GameEntity.Enemy.NormalEnemy;
import main.sample.GameObject;
import main.sample.Main;
import main.sample.Point;

import java.util.*;

import static main.sample.Main.gameObjects;
import static main.sample.Main.tick;

public class Spawner extends GameObject {

    int delayTime;
    int timeCreated;
    int numberofEnemy;

    public Spawner(int delayTime,int timeCreated,int numberofEnemy) {
        this.delayTime=delayTime;
        this.timeCreated=timeCreated;
        this.numberofEnemy=numberofEnemy;
        this.x=2;
        this.y=12;
        this.i=x* Config.scale;
        this.j=y* Config.scale;
    }


    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update() {
        ListIterator<GameObject> listIterator= gameObjects.listIterator();
        if(tick.getTime()==timeCreated) {
            for (int n = 0; n < numberofEnemy;n++) {
                if(tick.getTime()==timeCreated + delayTime* n ) listIterator.add(new NormalEnemy(2,12));
            }
        }

      /*  if(tick.getTime()==timeCreated) {
            for (int n = 0; n < numberofEnemy; n++) {
                if(tick.getTime()==timeCreated + delayTime * n) gameObjects.add(new NormalEnemy(2,12));
            }
        }*/
    //    for(ListIterator<GameObject> listIterator = gameObjects.listIterator(); listIterator.hasNext();){

     //   }

    }
}
