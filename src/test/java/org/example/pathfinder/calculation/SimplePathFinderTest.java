package org.example.pathfinder.calculation;


import org.example.pathfinder.data.SimpleVisualGraphLoader;
import org.example.pathfinder.data.model.Graph;
import org.example.pathfinder.data.model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class SimplePathFinderTest {

  //checks if found path actually exists and connects start with finish
  @Test
  public void TestCalculatingPath() throws IOException {
    Graph graph = SimpleVisualGraphLoader.loadSimpleVisualizedGraph("testVisualization1.txt");
    Node start = graph.getNode(0,0);
    Node finish = graph.getNode(2,3);
    SimplePathFinder.setPath(graph, start, finish);

    Assertions.assertNotNull(finish.getPrevious());
    Node current = finish;
    for(int i = 0; i < finish.getCost(); i++){
      Node prev = current.getPrevious();
      Assertions.assertTrue(prev.getNeighbours().contains(current));
      current = prev;
    }
    Assertions.assertEquals(current, start);
  }
}
