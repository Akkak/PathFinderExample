package org.example.pathfinder.calculation;

import org.example.pathfinder.data.model.Graph;
import org.example.pathfinder.data.model.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SimplePathFinder {

  public static void setPath(Graph graph, Node start, Node finish) {
    //this simple check probably should throw exception
    if (graph == null || graph.getGraphMap() == null || graph.getNode(start.getPosition()) == null || graph.getNode(finish.getPosition()) == null) {
      return;
    }

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
  }

  public static String getSimpleVisualPath(Node finish) {
    //dirty reverse for human readable-like output
    StringBuilder builder = new StringBuilder("{\"path\": \"");
    Node current = finish;
    Stack<Node> stack = new Stack<>();
    for (int i = 0; i <= finish.getCost(); i++) {
      Node prev = current.getPrevious();
      stack.add(current);
      current = prev;
    }
    if (!stack.empty())
      builder.append(stack.pop().getPosition().toString());
    while (!stack.empty()) {
      builder.append(" -> ").append(stack.pop().getPosition().toString());
    }

    builder.append("\"}");
    return builder.toString();
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
