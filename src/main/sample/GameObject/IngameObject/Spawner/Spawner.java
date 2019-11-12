package main.sample.GameObject.IngameObject.Spawner;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Enemy.*;
import main.sample.GameObject.GameObject;
import main.sample.GameObject.IngameObject.IngameObject;
import java.util.Random;

import java.util.*;

import static main.sample.Main.*;

public class Spawner extends IngameObject {

    int delayTime;
    int timeCreated;
    int numberofEnemy;
    Random random=new Random();


    List<AbtractEnemy> enemies=new ArrayList<>();

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
                if(tick.getTime()==timeCreated + delayTime * n) {
                    int rand=random.nextInt(3);
                    if(rand==0)
                        ingameObjects.add(new SmallerEnemy(2,12));
                    else if(rand==1)
                        ingameObjects.add(new NormalEnemy(2,12));
                    else if(rand==2)
                        ingameObjects.add(new TankerEnemy(2,12));
                    else
                        ingameObjects.add(new BossEnemy(2,12));

                }
            }

    //    for(ListIterator<GameObject> listIterator = gameObjects.listIterator(); listIterator.hasNext();){

     //   }

    }
}
