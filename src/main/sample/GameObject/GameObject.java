package main.sample.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface GameObject {


    void render(GraphicsContext gc);
    void update();

}
