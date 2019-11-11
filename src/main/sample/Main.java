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
import main.sample.GameObject.IngameObject.Tower.NormalTower;
import main.sample.GameObject.GameObject;
import main.sample.GameObject.OutgameObject.Lives;
import main.sample.GameObject.OutgameObject.OutgameObject;
import main.sample.GameObject.OutgameObject.Reward;
import main.sample.GameObject.OutgameObject.Tick;

import java.util.*;


public class Main extends Application{




  //  final public Scale srink=new Scale(0.5,0.5);
    public static GraphicsContext gc;
 //   public static List<GameObject> gameObjects = new ArrayList<>();
   // public static List<Spawner> spawners=new ArrayList<>();
 //   public static List<AbtractBullet> bullets=new ArrayList<>();
  //  public static List<NormalTower>
    public static Tick tick=new Tick();
    public static AnimationTimer timer;
    public static Reward reward=new Reward(300);
    public static Lives lives=new Lives(3);

    public static List<IngameObject> ingameObjects=new ArrayList<>();
    public static List<OutgameObject> outgameObjects=new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        Canvas canvas = new Canvas(Config.width * Config.scale, Config.height*Config.scale);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setTitle("main.sample.GameEntity.Tower Defense");

        stage.setResizable(false);

        Image image_button = new Image("file:src/main/AssetsKit_2/PlayButton.png");
        ImageView imageView_button=new ImageView(image_button);

        Image image_menu = new Image("file:src/main/AssetsKit_2/Menu.png");
        ImageView imageView_menu = new ImageView(image_menu);
        imageView_menu.setFitHeight(Config.height*Config.scale);
        imageView_menu.setFitWidth(Config.width*Config.scale);
        root.getChildren().add(imageView_menu);


        Button button=new Button("",imageView_button);
        button.setWrapText(true);
        button.setTranslateX(Config.width*Config.scale/2-192/2);
        button.setTranslateY(Config.height*Config.scale/2-128/2);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                root.getChildren().removeAll(imageView_menu, button);


                  timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {

                        render();
                        try{
                        update();}
                        catch (ConcurrentModificationException e){}


                    }

                };

                timer.start();

            }});
                outgameObjects.add(tick);
                outgameObjects.add(reward);
                outgameObjects.add(lives);
                ingameObjects.add(new NormalTower(4,5));
                ingameObjects.add(new NormalTower(9,3));

                ingameObjects.add(new Spawner(10,10,10));




                root.getChildren().add(button);
                stage.setScene(scene);
                stage.show();
            }

    public void update() {

        outgameObjects.forEach(OutgameObject::update);
        ingameObjects.forEach(IngameObject::update);

    }

    public void render() {

       // Map.autoDrawMap();

        Map.drawMapIn(gc);
        ingameObjects.forEach(g ->g.render(gc));
        Map.drawMapOut(gc);
        outgameObjects.forEach(g -> g.render(gc));



    }

    }




