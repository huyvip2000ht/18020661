package main.sample;

import javafx.scene.canvas.GraphicsContext;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Spawner.Spawner;

import java.util.ArrayList;
import java.util.List;

public class Levels extends IngameObject {
    public List<Spawner> spawners = new ArrayList<>();

    public Levels() {
     //   spawners.add(new Spawner(20, 10, 3, Config.NORMAL_ENEMY_CLASS));
     //   spawners.add(new Spawner(100, 10, 5, Config.SMALLER_ENEMY_CLASS));
     //   spawners.add(new Spawner(200,30,2,Config.TANKER_ENEMY_CLASS));
    //    spawners.add(new Spawner(400,0,1,Config.BOSS_ENEMY_CLASS));
    }

    @Override
    public void render(GraphicsContext gc) {
        spawners.forEach(g -> g.render(gc));
    }

    @Override
    public void update() {
        spawners.forEach(Spawner::update);
    }
}
