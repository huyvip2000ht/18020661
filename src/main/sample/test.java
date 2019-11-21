package main.sample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test extends Application{
    private Timeline t;
    private int xSpeed = 2;

    public static void main(String[] args){
        Application.launch(args);
    }
    public void start(Stage first){
        Group root = new Group();
        Scene field = new Scene(root, 500, 500);
        field.setFill(Color.GREY);

        Circle ball = new Circle(20);
        ball.setFill(Color.RED);
        ball.setCenterX(field.getHeight()/2);
        ball.setCenterY(field.getWidth()/2);

        Button btnStart=new Button("Start"), btnPause = new Button("Pause");
        btnPause.setLayoutX(50);

        root.getChildren().addAll(ball,btnStart,btnPause);

        first.setScene(field);
        first.show();
        pauseGame(btnPause,ball);
        startGame(btnStart,ball);
        KeyFrame k = new KeyFrame(Duration.millis(10), e ->{
            moveBall(ball);
        });
        t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
    }

    private void moveBall(Circle ball){
        ball.setCenterX(ball.getCenterX()+xSpeed);
        if(ball.getCenterX()>=500||ball.getCenterX()<=0){
            xSpeed=-xSpeed;
        }
    }

    private void startGame(Button start, Circle ball){
        start.setOnAction(e->{
            t.play();
        });
    }

    private void pauseGame(Button pause, Circle ball){
        pause.setOnAction(e->{
            t.pause();
        });
    }
}