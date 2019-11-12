package main.sample.GameObject.IngameObject.Enemy;

import main.sample.*;
import main.sample.Road;
import main.sample.GameObject.IngameObject.IngameObject;
import main.sample.GameObject.IngameObject.Tower.AbtractTower;

//import static main.sample.Main.gameObjects;
import static main.sample.Main.ingameObjects;

public abstract class AbtractEnemy extends IngameObject {

    public double health;
    public int reward;
    public int speed;
    public Direction direction;
    public int widthImg;
    public int heightImg;



  public int wayPointIndex = 0;
  public Point getNextWayPoint() {
    if (wayPointIndex < Road.wayPoints.length - 1)
      return Road.wayPoints[++wayPointIndex];
    return null;
  }


  public boolean isInRange(AbtractTower tower){
    if (Point.distance(this.centerI,this.centerJ,tower.centerI,tower.centerJ)
            <=tower.getFireRange()*Config.scale){
      return true;
    }
    return false;
  }

  void calculateDirection(){
    if (wayPointIndex >= Road.wayPoints.length-1) {
      // Enemy den way point cuoi
      Main.lives.setLives(Main.lives.getLives()-1);

      ingameObjects.remove(this);

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

    /*    ListIterator<GameObject> listIterator=gameObjects.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getClass().getName()=="main.sample.GameObject.IngameObject.Tower.NormalTower"){
                if(this.isInRange(listIterator.next().)) System.out.println();
            }
        }*/
    if(this.health<=0) {
      Main.reward.setReward(Main.reward.getReward()+this.reward);
      ingameObjects.remove(this);
    }

    for(IngameObject a:ingameObjects){

      if(a.getClass().getName()=="main.sample.GameObject.IngameObject.Tower.NormalTower"){
        if(this.isInRange((AbtractTower) a));
        //    System.out.println("Trong tầm");
        // System.out.println(Point.distance(this.centerI,this.centerJ,a.centerI,a.centerJ));
        /*    System.out.println("i enemy:"+centerI);
            System.out.println("j enemy:"+centerJ);
            System.out.println("i tower:"+a.centerI);
            System.out.println("j tower"+a.centerJ);*/
      }


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
