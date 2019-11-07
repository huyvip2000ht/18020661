package main.sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {
    int i, j;
    int x;
    int y;
    Image img;

    public abstract void render(GraphicsContext gc);
    abstract void update();

}
