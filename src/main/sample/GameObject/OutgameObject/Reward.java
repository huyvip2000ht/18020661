package main.sample.GameObject.OutgameObject;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;

public class Reward extends OutgameObject {

    public int reward;

    public Reward(int reward){
        this.reward=reward;

        this.i=13* Config.SCALE;
        this.j=2*Config.SCALE;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String toString(){
        return "Reward: "+String.valueOf(reward);
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.fillText(toString(),i,j);
    }

    @Override
    public void update() {

    }
}
