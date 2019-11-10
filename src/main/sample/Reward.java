package main.sample;

import javafx.scene.canvas.GraphicsContext;

public class Reward extends GameObject {

    public int reward;

    public Reward(int reward){
        this.reward=reward;
        this.x=13;
        this.y=2;
        this.i=x*Config.scale;
        this.j=y*Config.scale;
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
