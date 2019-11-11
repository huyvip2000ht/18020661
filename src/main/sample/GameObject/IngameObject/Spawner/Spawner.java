package main.sample.GameObject.IngameObject.Spawner;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Enemy.NormalEnemy;
import main.sample.GameObject.GameObject;
import main.sample.GameObject.IngameObject.IngameObject;

import java.util.*;

import static main.sample.Main.*;

public class Spawner extends IngameObject {

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
       /* ListIterator iterator=ingameObjects.listIterator();

        if(tick.getTime()==timeCreated) {
            for (int n = 0; n < numberofEnemy;n++) {
                if(tick.getTime()==timeCreated + delayTime* n ) iterator.add(new NormalEnemy(2,12));
            }
        }*/

            for (int n = 0; n < numberofEnemy; n++) {
                if(tick.getTime()==timeCreated + delayTime * n) ingameObjects.add(new NormalEnemy(2,12));
            }

    //    for(ListIterator<GameObject> listIterator = gameObjects.listIterator(); listIterator.hasNext();){

     //   }

    }
}
