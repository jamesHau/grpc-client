package com.example.grpcclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("manual")
@Slf4j
public class ApiController {

  final ExampleService exampleService;

  public ApiController(ExampleService exampleService) {
    this.exampleService = exampleService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Response get() {
    log.info("Received a request!");
    String response = exampleService.test("manual");
    return Response.builder().message(response).build();
  }
}
