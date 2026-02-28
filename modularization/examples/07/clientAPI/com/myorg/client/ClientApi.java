package com.myorg.client;

public class ClientApi {
  public String getInfo() {
    return "This is ClientApi, it is a part of " + ClientApi.class.getModule() ;
  }
  public com.myorg.client.Helper getHelper() {
    return new com.myorg.impl.HelperImpl();
  }
}

