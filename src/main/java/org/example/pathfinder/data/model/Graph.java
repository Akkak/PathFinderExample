package org.example.pathfinder.data.model;

import java.util.Map;

public class Graph {
  Map<Position, Node> graphMap;

  public Graph(Map<Position, Node> graphMap) {
    this.graphMap = graphMap;
  }

  public Map<Position, Node> getGraphMap() {
    return graphMap;
  }

  public void setGraphMap(Map<Position, Node> graphMap) {
    this.graphMap = graphMap;
  }

  public Node getNode(int x, int y){
    return graphMap.get(new Position(x,y));
  }

  public Node getNode(Position pos){
    return graphMap.get(pos);
  }
}
