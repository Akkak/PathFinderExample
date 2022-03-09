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

  @Test
  public void testIfItWorks() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/path-finder"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.value", Matchers.is("It works!")));
  }
}
