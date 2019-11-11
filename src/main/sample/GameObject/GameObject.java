package main.sample.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface GameObject {


    public abstract void render(GraphicsContext gc);
    public abstract void update();

}
