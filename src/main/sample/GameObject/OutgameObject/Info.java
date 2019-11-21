package main.sample.GameObject.OutgameObject;


import javafx.scene.canvas.GraphicsContext;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

import javafx.event.EventHandler;

import javafx.scene.input.MouseEvent;

public class Info  {

    AbtractTower owner;

    public void showInfo(AbtractTower owner){
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

            }
        };
    }
    public void drawInfoCorner(GraphicsContext gc){
     //   gc.strokeRect(13*);
    }

}
