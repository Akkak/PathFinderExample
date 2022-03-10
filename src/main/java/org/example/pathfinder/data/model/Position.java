package org.example.pathfinder.data.model;

//for simplyfying Graph to 2 dimensional 'map', just for easier mental visualization of graph
//for better solution I could just use Table from Guava
public class Position {
  int x;
  int y;

  public Position(int x, int y){
    this.x = x;
    this.y = y;
  }

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

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Position)) return false;
    Position secondPosition = (Position) o;
    return x == secondPosition.x && y == secondPosition.y;
  }

  @Override
  public int hashCode() {
    //super simple hashing mechanism
    return 71 * x + y;
  }
}
