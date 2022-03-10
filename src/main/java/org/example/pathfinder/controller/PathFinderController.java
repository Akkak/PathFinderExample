package org.example.pathfinder.controller;

import org.example.pathfinder.calculation.SimplePathFinder;
import org.example.pathfinder.data.SimpleVisualGraphLoader;
import org.example.pathfinder.data.model.Graph;
import org.example.pathfinder.data.model.Node;
import org.example.pathfinder.data.request.PathFinderRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path-finder")
public class PathFinderController {

  @GetMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getSimplePath(PathFinderRequest request) {
    Node finish;
    try {
      Graph graph = SimpleVisualGraphLoader.loadSimpleVisualizedGraph(request.getPath());
      finish = graph.getNode(request.getFinishX(), request.getFinishY());
      SimplePathFinder.setPath(
        graph,
        graph.getNode(request.getStartX(), request.getStartY()),
        finish);
    } catch (Exception ex) {
      //should throw better status/statuses
      return ResponseEntity.internalServerError().build();
    }
    return ResponseEntity.ok(SimplePathFinder.getSimpleVisualPath(finish));
  }

}
