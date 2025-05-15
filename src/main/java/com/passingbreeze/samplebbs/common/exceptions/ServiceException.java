package com.passingbreeze.samplebbs.common.exceptions;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

  private final String code;
  private final String message;

  public ServiceException(ServiceExceptionCode response) {
    super(response.getMessage());
    this.code = response.getCode();
    this.message = super.getMessage();
  }

  @Override
  public String getMessage() {
    return message;
  }
}
