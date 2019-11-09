package main.sample;

import javafx.scene.canvas.GraphicsContext;

public class Tick extends GameObject {
    public  int[] time={0};
    public void upTime(){
        time[0]++;
    }


    public String toString() {
        return  String.valueOf(time[0])  ;
    }

    public int getTime() {
        return time[0];
    }

    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update() {
        time[0]++;
        System.out.println(time[0]);
    }
}
