package main.sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Spawner.Spawner;
import main.sample.GameObject.OutgameObject.*;
import javafx.event.EventHandler;
import java.util.*;


public class Main extends Application {


    public static GraphicsContext gc;
    public static Tick tick = new Tick();
    public static AnimationTimer timer;
    public static Reward reward = new Reward();
    public static Lives lives = new Lives(Config.LIVES);
    public static Store store = new Store();
    public static NextWaveButton nextWaveButton=new NextWaveButton();
    public static Group root = new Group();
    public static Scene scene = new Scene(root);
    public static List<IngameObject> ingameObjects = new ArrayList<>();
    public static List<OutgameObject> outgameObjects = new ArrayList<>();
    public static Spawner spawner = new Spawner();


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        Canvas canvas = new Canvas(Config.WIDTH * Config.SCALE, Config.HEIGHT * Config.SCALE);
        gc = canvas.getGraphicsContext2D();

        // Tao root container

        root.getChildren().add(canvas);



        stage.setTitle("main.sample.GameEntity.Tower Defense");
        stage.setResizable(false);


        Menu menu=new Menu();
        menu.add();



        menu.imageView_button.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent actionEvent) {

                root.getChildren().removeAll(menu.imageView_menu, menu.imageView_button);
                root.getChildren().add(Store.normal);
                root.getChildren().add(Store.machineGun);
                root.getChildren().add(Store.sniper);
                root.getChildren().add(Store.selling);
                root.getChildren().add(NextWaveButton.imageView);

                timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        try {
                            render();

                            update();
                        }
                        catch (ConcurrentModificationException e) {}


                    }

                };

                timer.start();

            }
        }));
        Map.autoDrawMap();
        outgameObjects.add(tick);
        outgameObjects.add(reward);
        outgameObjects.add(store);
        outgameObjects.add(lives);

        ingameObjects.add(spawner);



        SoundTrack.backgroundMediaPlayer.play();


        stage.setScene(scene);
        stage.show();
    }

    public static void update() {
        ingameObjects.forEach(IngameObject::update);
        outgameObjects.forEach(OutgameObject::update);



    }

    public static void render() {

        //  Map.autoDrawMap();
        //   System.out.println();
    //    Map.draw();
        Map.drawMapIn(gc);
     //   Road.drawPoints(gc);
        ingameObjects.forEach(g -> g.render(gc));
        Map.drawMapOut(gc);
        outgameObjects.forEach(g -> g.render(gc));

    }

}




