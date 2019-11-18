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
import javafx.stage.Stage;

import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Spawner.Spawner;
import main.sample.GameObject.OutgameObject.*;

import java.util.*;


public class Main extends Application {


    //  final public Scale srink=new Scale(0.5,0.5);
    public static GraphicsContext gc;
    //   public static List<GameObject> gameObjects = new ArrayList<>();
    // public static List<Spawner> spawners=new ArrayList<>();
    //   public static List<AbtractBullet> bullets=new ArrayList<>();
    //  public static List<NormalTower>
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
    public static SoundTrack soundTrack=new SoundTrack();

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

        // Tao scene
        //      Scene scene = new Scene(root);



/*
        Group root1 = new Group();
        root1.getChildren().add(canvas);
        Scene scene1=new Scene(root1);
*/


        stage.setTitle("main.sample.GameEntity.Tower Defense");
        stage.setResizable(false);


        Image image_button = new Image("file:src/main/AssetsKit_2/PlayButton.png");
        ImageView imageView_button = new ImageView(image_button);

        Image image_menu = new Image("file:src/main/AssetsKit_2/Menu.png");
        ImageView imageView_menu = new ImageView(image_menu);
        imageView_menu.setFitHeight(Config.HEIGHT * Config.SCALE);
        imageView_menu.setFitWidth(Config.WIDTH * Config.SCALE);
        root.getChildren().add(imageView_menu);


        Button button = new Button("", imageView_button);
        button.setWrapText(true);
        button.setTranslateX(Config.WIDTH * Config.SCALE / 2 - 192 / 2);
        button.setTranslateY(Config.HEIGHT * Config.SCALE / 2 - 128 / 2);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                root.getChildren().removeAll(imageView_menu, button);
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
                        } catch (ConcurrentModificationException e) {
                        }


                    }

                };

                timer.start();

            }
        });
        Map.autoDrawMap();
        outgameObjects.add(tick);
        outgameObjects.add(reward);
        outgameObjects.add(store);
        outgameObjects.add(lives);

        ingameObjects.add(spawner);

        root.getChildren().add(button);

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




