package main.sample.GameObject.IngameObject.Spawner;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.sample.Config;
import main.sample.GameObject.IngameObject.Enemy.*;
import main.sample.GameObject.IngameObject.IngameObject;

import java.util.Random;

import java.util.*;

import static main.sample.Main.*;

public class Spawner extends IngameObject {

    private int delayTime;
    public int timeCreated;
    private int numberofEnemy;



    public List<AbtractEnemy> enemies = new ArrayList<>();


    public int index=1;
    private boolean check;


    public Spawner() {
     /*   this.delayTime = delayTime;
        this.timeCreated = timeCreated;
        this.numberofEnemy = numberofEnemy;*/

        this.x = 2;
        this.y = 12;
        this.i = x * Config.SCALE;
        this.j = y * Config.SCALE;
    }


    @Override
    public void render(GraphicsContext gc) {
        enemies.forEach(g -> g.render(gc));

    }

    private void LV(int level) {
        if (level == 1) {
            numberofEnemy = 7;
            timeCreated = 30;
            delayTime = 20;
            for (int n = 0; n < numberofEnemy; n++) {
                if (tick.getTime() == timeCreated + delayTime * n) {
                    enemies.add(new NormalEnemy(2,12));
                }
            }
        }
        else if (level == 2) {
            numberofEnemy=10;

            delayTime=20;
            for (int n = 0; n < numberofEnemy; n++) {
                if (tick.getTime() == timeCreated + delayTime * n) {

                    enemies.add(new SmallerEnemy(2, 12));
                }
            }
        }
        else if (level == 3){
            numberofEnemy=20;

            delayTime=20;
            for (int n = 0; n < numberofEnemy; n++) {
                if (tick.getTime() == timeCreated + delayTime * n) {
                    if(check) {
                        check= false;
                        enemies.add(new SmallerEnemy(2, 12));
                    }
                    else {
                        check=true;
                        enemies.add(new NormalEnemy(2,12));
                    }

                }
            }
        }
        else if(level == 4){
            numberofEnemy=3;
            delayTime=20;
            for (int n = 0; n < numberofEnemy; n++) {
                if (tick.getTime() == timeCreated + delayTime * n) {

                    enemies.add(new TankerEnemy(2, 12));
                }
            }
        }
        else if(level ==5){
            numberofEnemy=1;
            delayTime=0;
            for (int n = 0; n < numberofEnemy; n++) {
                if (tick.getTime() == timeCreated + delayTime * n) {

                    enemies.add(new BossEnemy(2, 12));
                }
            }
        }
    }


    @Override
    public void update() {
        LV(index);

        if(enemies.isEmpty()&&tick.getTime()>=timeCreated){
            timeCreated=tick.getTime()+1;
         //   index++;

        }

        enemies.forEach(AbtractEnemy::update);

         /*   for (int n = 0; n < numberofEnemy; n++) {
                if(tick.getTime()==timeCreated + delayTime * n) {

                    if(enemyClass==Config.SMALLER_ENEMY_CLASS)
                        enemies.add(new SmallerEnemy(2,12));
                    else if(enemyClass==Config.NORMAL_ENEMY_CLASS)
                        enemies.add(new NormalEnemy(2,12));
                    else if(enemyClass==Config.TANKER_ENEMY_CLASS)
                        enemies.add(new TankerEnemy(2,12));
                    else if(enemyClass==Config.BOSS_ENEMY_CLASS)
                        enemies.add(new BossEnemy(2,12));

                }
            }*/



    }
}
