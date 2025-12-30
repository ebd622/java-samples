package com.myorg.first;

public class FirstApi {
  public String getInfo() {
    return "This is FirstApi, it is a part of " + FirstApi.class.getModule() ;
  }
}