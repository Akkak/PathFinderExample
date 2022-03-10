package org.example.pathfinder.data;

import org.example.pathfinder.data.model.Graph;
import org.example.pathfinder.data.model.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class SimpleVisualGraphLoaderTests {


  @Test
  public void loadCorrectFileTest() throws IOException {
    Graph graph = SimpleVisualGraphLoader.loadSimpleVisualizedGraph("testVisualization1.txt");
    Assertions.assertNotNull(graph);
  }

  @Test
  public void loadIncorrectFileTest() {
    Exception exception = Assertions.assertThrows(IOException.class, () ->
      SimpleVisualGraphLoader.loadSimpleVisualizedGraph("somethingWrong.txt"));

    Assertions.assertNotNull(exception.getMessage());
  }

  @Test
  public void checkIfCorrectlyLoadedPoints() throws IOException {
    Graph graph = SimpleVisualGraphLoader.loadSimpleVisualizedGraph("testVisualization1.txt");
    Assertions.assertNotNull(graph.getNode(0, 0));
    Assertions.assertNull(graph.getNode(0, 1));

    List<Node> expectedNodes = List.of(graph.getNode(1, 0));
    Assertions.assertIterableEquals(graph.getNode(0, 0).getNeighbours(), expectedNodes);

    expectedNodes = List.of(
      graph.getNode(1, 0), graph.getNode(2, 0), graph.getNode(3, 0),
      graph.getNode(3, 1),
      graph.getNode(1, 2), graph.getNode(3, 2));
    Assertions.assertTrue(expectedNodes.containsAll(graph.getNode(2, 1).getNeighbours()));
    Assertions.assertTrue(graph.getNode(2, 1).getNeighbours().containsAll(expectedNodes));
  }
}
