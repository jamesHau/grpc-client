package com.example.grpcclient;

import com.example.grpcdemo.ExampleProtos;
import com.example.grpcdemo.ExampleServiceGrpc.ExampleServiceBlockingStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UnitTestExampleServiceTest {

  private final ExampleService exampleService = new ExampleService();

  @Mock
  private ExampleServiceBlockingStub exampleServiceBlockingStub;

  @BeforeEach
  void setup() {
    reset(exampleServiceBlockingStub);
    exampleService.setExampleServiceBlockingStub(exampleServiceBlockingStub);
  }

  @Test
  void testService() {
    when(exampleServiceBlockingStub.exampleMethod(any())).thenReturn(
            ExampleProtos.ExampleResponse.newBuilder().setResponse("mocked").build());

    String response = exampleService.test("my input");

    assertEquals("mocked", response);
  }

}
