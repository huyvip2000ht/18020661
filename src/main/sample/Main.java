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

import main.sample.GameEntity.Enemy.NormalEnemy;
import main.sample.GameEntity.Map;
import main.sample.GameEntity.Road;
import main.sample.GameEntity.Spawner;
import main.sample.GameEntity.Tower.NormalTower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Main extends Application{




  //  final public Scale srink=new Scale(0.5,0.5);
    public static GraphicsContext gc;
    public static List<GameObject> gameObjects = new ArrayList<>();
  //  public static List<NormalTower>
    public static Tick tick=new Tick();
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

     /*   Image image_button = new Image("file:src/main/AssetsKit_2/PlayButton.png");
        ImageView imageView_button=new ImageView(image_button);

        Image image_menu = new Image("file:src/main/AssetsKit_2/Menu.png");
        ImageView imageView_menu = new ImageView(image_menu);
        imageView_menu.setFitHeight(Config.height*Config.scale);
        imageView_menu.setFitWidth(Config.width*Config.scale);
        root.getChildren().add(imageView_menu);


        Button button=new Button("",imageView_button);
        button.setWrapText(true);
        button.setTranslateX(Config.width*Config.scale/2-192/2);
        button.setTranslateY(Config.height*Config.scale/2-128/2);*/

     //   button.setOnAction(new EventHandler<ActionEvent>() {
      //      @Override
      //      public void handle(ActionEvent actionEvent) {

       //         root.getChildren().removeAll(imageView_menu,button);



                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {

                        render();
                        update();

                    }
                };
                timer.start();

                gameObjects.add(tick);

                gameObjects.add(new NormalTower(4,5));
                gameObjects.add(new NormalTower(10,3));
                gameObjects.add(new NormalEnemy(2,12));
                gameObjects.add(new Spawner(5,10,3));
            /*    Image  test =new Image("file:src/main/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
                ImageView testView=new ImageView(test);
                gc.save();
                gc.rotate(45);
                gc.drawImage(test,10,10);
                gc.restore();*/



             /*   if(tick.getTime()==0){
                    for (int x=0;x<10;x++){
                        if(tick.getTime()==10+x*5) gameObjects.add(new NormalEnemy(2,12));
                    }
                }*/

           //


                stage.setScene(scene);
                stage.show();
            }

    public void update() {
        gameObjects.forEach(GameObject::update);

    }

    public void render() {
        Map.drawMap(gc);
        Road.drawPoints(gc);
      //  for(ListIterator<GameObject> listIterator=gameObjects.listIterator();listIterator.hasNext();){

       // }
        gameObjects.forEach(g -> g.render(gc));
    }



       // root.getChildren().add(button);





       // gameObjects.add(createTank());
        //gameObjects.add(createTower());
    }




