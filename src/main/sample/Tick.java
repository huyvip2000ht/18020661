package main.sample;

import javafx.scene.canvas.GraphicsContext;

public class Tick extends GameObject {
    public  int[] time={0};
    public long second=System.currentTimeMillis();
    public double fps;
    public int a;

    public Tick(){
        this.x=13;
        this.y=1;
        this.i=Config.scale*x;
        this.j=Config.scale*y;
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
     //   System.out.println(time[0]);

        second=System.currentTimeMillis()/1000;
    }
}
