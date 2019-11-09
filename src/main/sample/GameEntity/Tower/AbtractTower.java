package main.sample.GameEntity.Tower;

import main.sample.GameObject;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public abstract class AbtractTower extends GameObject {

    double damage;
    double fireRate;
    double fireRange;

    int rotation;

   /* public AbtractTower(int x,int y,double damage,double fireRate,double fireRange,Image gunImg,Image baseImg){
        this.x=x;
        this.y=y;
        this.damage=damage;
        this.fireRate=fireRate;
        this.fireRange=fireRange;
        this.gunImg=gunImg;
        this.baseImg=baseImg;
    }*/


}
