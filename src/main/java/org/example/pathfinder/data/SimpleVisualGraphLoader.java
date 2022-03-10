package org.example.pathfinder.data;

import org.example.pathfinder.data.model.Graph;
import org.example.pathfinder.data.model.Node;
import org.example.pathfinder.data.model.Position;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimpleVisualGraphLoader {

  public static Graph loadSimpleVisualizedGraph(String path) throws IOException {
    File visualGraphFile = getGraphFile(path);
    BufferedReader reader = new BufferedReader(new FileReader(visualGraphFile));
    Map<Position, Node> points = new HashMap<>();
    int y = 0;
    //in theory, shouldn't do that this way, but in this case this should be ok
    String line = reader.readLine();
    while(line != null){
      String[] letters = line.split(" ");
      for (int x = 0; x < letters.length; x++)
        if (letters[x].equals("_")){
          Node temp = new Node(new Position(x, y));
          points.put(temp.getPosition(), temp);
        }
      line = reader.readLine();
      y++;
    }
    points.values().forEach(point -> {
      for(int i = -1; i <= 1; i++){
        for(int j = -1; j <= 1; j++){
          point.addNeighbour(points.get(new Position(point.getX() + i, point.getY() + j)));
        }
      }
    });
    return new Graph(points);
  }


  private static File getGraphFile(String fileName) throws IOException {
    return new ClassPathResource("/static/" + fileName).getFile();
  }

}
