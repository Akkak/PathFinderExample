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
}
