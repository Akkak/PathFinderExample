package org.example.pathfinder.data.request;

public class PathFinderRequest {
  String path;
  int startX;
  int startY;
  int finishX;
  int finishY;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public int getStartX() {
    return startX;
  }

  public void setStartX(int startX) {
    this.startX = startX;
  }

  public int getStartY() {
    return startY;
  }

  public void setStartY(int startY) {
    this.startY = startY;
  }

  public int getFinishX() {
    return finishX;
  }

  public void setFinishX(int finishX) {
    this.finishX = finishX;
  }

  public int getFinishY() {
    return finishY;
  }

  public void setFinishY(int finishY) {
    this.finishY = finishY;
  }
}
