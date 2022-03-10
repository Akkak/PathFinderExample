package org.example.pathfinder.data.model;

import java.util.LinkedList;
import java.util.List;

public class Node {
  Position position;
  List<Node> neighbours;

  public Node(Position position){
    this.position = position;
    neighbours = new LinkedList<>();
  }

  public Node(Position position, List<Node> neighbours){
    this.position = position;
    this.neighbours = neighbours;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public List<Node> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<Node> neighbours) {
    this.neighbours = neighbours;
  }

  public boolean addNeighbour(Node neighbour) {
    if (neighbour != null && neighbour != this) {
      neighbours.add(neighbour);
      return true;
    }
    return false;
  }

  public int getX() {
    return position.getX();
  }

  public int getY() {
    return position.getY();
  }
}
