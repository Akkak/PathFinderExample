package org.example.pathfinder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PathFinderController.class)
public class PathFinderControllerTests {
  @Autowired
  MockMvc mockMvc;
  @Autowired
  ObjectMapper mapper;

  //hardcoded sanity test if request works
  @Test
  public void testIfFindsPath() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/path-finder/simple?path=testVisualization1.txt&finishX=1&finishY=2"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.path", Matchers.is("(0,0) -> (1,0) -> (2,1) -> (1,2)")));
  }

  //hardcoded sanity test for bad request data
  @Test
  public void testIfThrowsException() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/path-finder/simple?path=testVisualization1.txt&finishX=1&finishY=99"))
      .andExpect(status().isInternalServerError());
  }
}
