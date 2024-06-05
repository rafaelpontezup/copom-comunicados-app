package br.com.graphene.copom.sampledynamo.dto;

public class ErrorResponseMessage {
  private final int code;
  private final String message;

  public ErrorResponseMessage(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}

