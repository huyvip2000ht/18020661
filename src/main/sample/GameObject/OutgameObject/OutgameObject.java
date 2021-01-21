package main.sample.GameObject.OutgameObject;

import main.sample.GameObject.GameObject;

public abstract class OutgameObject implements GameObject {
    public int i, j;

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
}
