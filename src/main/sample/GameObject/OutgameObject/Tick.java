package main.sample.GameObject.OutgameObject;

import javafx.scene.canvas.GraphicsContext;
import main.sample.Config;

public class Tick extends OutgameObject {
    private int[] time={0};
    private long second=System.currentTimeMillis();
    private double fps;
    private int a;

    public Tick(){

        this.i= 13 * Config.SCALE;
        this.j= 1  * Config.SCALE;
    }

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
     gc.fillText("FPS: "+String.valueOf(fps),i,j);
    }

    @Override
    public void update() {
        time[0]++;
        if(System.currentTimeMillis()/1000!=second){
            fps=getTime()-a;
           // System.out.println("FPS: "+String.valueOf(getTime()-a));

            a=getTime();
        }
     //  System.out.println(time[0]);

        second=System.currentTimeMillis()/1000;
    }
}
