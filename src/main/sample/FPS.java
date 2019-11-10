package main.sample;

import javafx.scene.canvas.GraphicsContext;

public class FPS extends Tick {
    public long second;
    public double fps;
    public FPS(){
        second=System.currentTimeMillis()/1000;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.fillText("FPS: "+fps,1,13);
    }

    @Override
    public void update() {
        fps=System.currentTimeMillis()/1000-second;
        second=System.currentTimeMillis()/1000;
        upTime();
        System.out.println(fps);

    }


}
