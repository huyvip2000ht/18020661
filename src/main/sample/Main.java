package main.sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import main.sample.GameTile.Map;
import main.sample.GameTile.Road;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application{




  //  final public Scale srink=new Scale(0.5,0.5);
    public GraphicsContext gc;
    public List<GameObject> gameObjects = new ArrayList<>();

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
        stage.setTitle("Tower Defense");
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

                root.getChildren().removeAll(imageView_menu,button);

                final int[] time = {0};

                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {

                        render();
                        update();
                        time[0]++;
                        System.out.println(time[0]);
                    }
                };
                timer.start();
            }
        });


        root.getChildren().add(button);



        stage.setScene(scene);
        stage.show();

       // gameObjects.add(createTank());
        //gameObjects.add(createTower());
    }
    public void update() {
        gameObjects.forEach(GameObject::update);
    }

    public void render() {
        Map.drawMap(gc);
        Road.drawPoints(gc);
        gameObjects.forEach(g -> g.render(gc));
    }


}
