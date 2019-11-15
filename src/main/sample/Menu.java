package main.sample;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Menu extends Application {
    @Override
    public void start(Stage stage){

        Group root1=new Group();
        Scene scene=new Scene(root1);
    Image image_button = new Image("file:src/main/AssetsKit_2/PlayButton.png");
    ImageView imageView_button=new ImageView(image_button);

    Image image_menu = new Image("file:src/main/AssetsKit_2/Menu.png");
    ImageView imageView_menu = new ImageView(image_menu);
        imageView_menu.setFitHeight(Config.HEIGHT *Config.SCALE);
        imageView_menu.setFitWidth(Config.WIDTH *Config.SCALE);
        root1.getChildren().add(imageView_menu);


    Button button=new Button("",imageView_button);
        button.setWrapText(true);
        button.setTranslateX(Config.WIDTH *Config.SCALE /2-192/2);
        button.setTranslateY(Config.HEIGHT *Config.SCALE /2-128/2);
        stage.setScene(scene);
       button.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {

               root1.getChildren().removeAll(imageView_menu, button);
            //   stage.setScene(Main.scene);
               Application.launch();
             //  stage.setScene(Main.scene);
             //  stage.show();


           }
       });
       root1.getChildren().add(button);

        stage.show();


    }
}
