package com.example.grpcclient;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Response {

  String message;
}
