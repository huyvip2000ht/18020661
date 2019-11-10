package main.sample;

import javafx.scene.canvas.GraphicsContext;

public class Lives extends GameObject {
    public int lives;
    public Lives(int lives){
        this.lives=lives;
        this.x=13;
        this.y=3;
        this.i=x*Config.scale;
        this.j=y*Config.scale;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "Lives: " +String.valueOf(lives);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.fillText(toString(),i,j);
    }

    @Override
    public void update() {

    }
}
