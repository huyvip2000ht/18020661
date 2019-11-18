package main.sample.GameObject.IngameObject.Enemy;

import javafx.scene.media.MediaPlayer;
import main.sample.*;
import main.sample.Road;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

//import static main.sample.Main.gameObjects;
import static main.sample.Main.ingameObjects;
import static main.sample.Main.spawner;

public abstract class AbtractEnemy extends IngameObject {


    int reward;
    double speed;
    Direction direction;

    public double health;
    public int widthImg;
    public int heightImg;

    private int wayPointIndex = 0;


  private Point getNextWayPoint() {
    if (wayPointIndex < Road.wayPoints.length - 1)
      return Road.wayPoints[++wayPointIndex];
    return null;
  }


  public boolean isInRange(AbtractTower tower){
    if (Point.distance(this.centerI,this.centerJ,tower.centerI,tower.centerJ)
            <=tower.getFireRange()*Config.SCALE){
      return true;
    }
    return false;
  }

  private void calculateDirection(){
    if (wayPointIndex >= Road.wayPoints.length-1) {
      // Enemy den way point cuoi
      Main.lives.setLives(Main.lives.getLives()-1);
      MediaPlayer a=new MediaPlayer(SoundTrack.enemyThroughMedia);
      a.play();
      spawner.enemies.remove(this);

    }

    Point currentWP = Road.wayPoints[wayPointIndex];
    if (Point.distance(i, j, currentWP.getX(), currentWP.getY()) <= speed) {
      i = currentWP.getX();
      j = currentWP.getY();
      Point nextWayPoint = getNextWayPoint();
      if (nextWayPoint == null) return;
      double deltaX = nextWayPoint.getX() - i;
      double deltaY = nextWayPoint.getY() - j;
      if (deltaX > speed) direction = Direction.RIGHT;
      else if (deltaX < -speed) direction = Direction.LEFT;
      else if (deltaY > speed) direction = Direction.DOWN;
      else if (deltaY <= -speed) direction = Direction.UP;
    }
  }




  @Override
  public void update() {


    if(this.health<=0) {
      Main.reward.setReward(Main.reward.getReward()+this.reward);
      spawner.enemies.remove(this);
    }


    calculateDirection();

    switch (direction) {
      case UP:
        j -= speed;
        centerJ-=speed;
        break;
      case DOWN:
        j += speed;
        centerJ+=speed;
        break;
      case LEFT:
        i -= speed;
        centerI-=speed;
        break;
      case RIGHT:
        i += speed;
        centerI+=speed;
        break;
    }
  }





}
