package com.myorg.client;

import com.myorg.first.FirstApi;

class ClientApp {
  public String getInfo() { return "This is ClientApp"; }

  public static void main(String args[]) {
    var second = new ClientApp();

    System.out.println(second.getInfo());

    System.out.println(new FirstApi().getInfo());
  }
}

