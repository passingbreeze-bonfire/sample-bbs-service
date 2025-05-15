package com.passingbreeze.samplebbs.common.exceptions;

import lombok.Getter;

@Getter
public enum ServiceExceptionCode {

  SERVER_ERROR("SERVER_ERROR", "서버 에러가 발생했습니다."),
  ;

  private final String code;
  private final String message;

  ServiceExceptionCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String toString() {
    return "code : " + code + ", message : " + message;
  }
}
