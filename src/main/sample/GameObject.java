package main.sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {
    public int i;
    public int j;
    public int x;
    public int y;


    public abstract void render(GraphicsContext gc);
    public abstract void update();

}
