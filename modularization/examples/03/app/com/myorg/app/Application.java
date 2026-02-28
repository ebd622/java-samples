package com.myorg.app;

import com.myorg.client.ClientApi;

class Application {
  public String getInfo() { return "This is Application, it is a part of " + Application.class.getModule(); }

  public static void main(String args[]) {
    System.out.println(new Application().getInfo());
    System.out.println(new ClientApi().getInfo());
  }
}
