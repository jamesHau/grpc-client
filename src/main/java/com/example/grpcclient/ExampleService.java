package com.example.grpcclient;

import com.example.grpcdemo.ExampleProtos;
import com.example.grpcdemo.ExampleServiceGrpc;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleService {

  @Setter
  @GrpcClient("exampleService")
  private ExampleServiceGrpc.ExampleServiceBlockingStub exampleServiceBlockingStub;

  public String test(String message) {
    ExampleProtos.ExampleRequest exampleRequest = ExampleProtos.ExampleRequest.newBuilder().setMessage(message).build();

    log.info("Calling the grpc exampleService");
    ExampleProtos.ExampleResponse exampleResponse = exampleServiceBlockingStub.exampleMethod(exampleRequest);
    return exampleResponse.getResponse();
  }
}
