package main.sample.GameObject.IngameObject;

import main.sample.GameObject.GameObject;

public abstract class IngameObject implements GameObject {
    public int x, y, i, j, centerI, centerJ;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getCenterI() {
        return centerI;
    }

    public void setCenterI(int centerI) {
        this.centerI = centerI;
    }

    public int getCenterJ() {
        return centerJ;
    }

    public void setCenterJ(int centerJ) {
        this.centerJ = centerJ;
    }
}
