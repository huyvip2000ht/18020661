package main.sample.GameObject.OutgameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import main.sample.Config;
import main.sample.Main;

import java.util.List;

import static main.sample.Main.*;

public class Lives extends OutgameObject {
    private int lives;
    public Lives(int lives){
        this.lives=lives;

        this.i=13* Config.SCALE;
        this.j=3*Config.SCALE;
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
        gc.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR,25));
        gc.fillText(toString(),i,j);
        if(lives<=0) {

            ImageView gameover=new ImageView(new Image("file:src/main/AssetsKit_2/Gameover.jpg"));
            gameover.setFitWidth(16*Config.SCALE);
            gameover.setFitHeight(12*Config.SCALE);
            root.getChildren().add(gameover);

        }
    }

    @Override
    public void update() {

    }
}
