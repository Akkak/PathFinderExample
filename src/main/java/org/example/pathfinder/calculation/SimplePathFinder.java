package org.example.pathfinder.calculation;

import org.example.pathfinder.data.model.Graph;
import org.example.pathfinder.data.model.Node;

import java.util.HashSet;
import java.util.Set;

public class SimplePathFinder {

  public static void setPath(Graph graph, Node start, Node finish) {
    Set<Node> visited = new HashSet<>();
    Set<Node> unVisited = new HashSet<>();

    start.setCost(0);
    unVisited.add(start);

    while (unVisited.size() != 0) {
      Node current = getClosestUnvisitedNode(unVisited);
      unVisited.remove(current);

      for (Node neighbour : current.getNeighbours()) {
        if (!visited.contains(neighbour)) {
          unVisited.add(neighbour);
          if (neighbour.getCost() > current.getCost() + 1) {
            neighbour.setCost(current.getCost() + 1);
            neighbour.setPrevious(current);
          }
        }
      }
      visited.add(current);
    }
    int i = 0;
  }

  private static Node getClosestUnvisitedNode(Set<Node> unvisited) {
    Node lowestNode = null;
    int lowestCost = Integer.MAX_VALUE;

    for (Node node : unvisited) {
      int nodeCost = node.getCost();
      if (nodeCost < lowestCost) {
        lowestCost = nodeCost;
        lowestNode = node;
      }
    }
    return lowestNode;
  }
}
