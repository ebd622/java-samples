package com.myorg.client;

import com.myorg.first.FirstApi;

class ClientApp {
  public String getInfo() { return "This is ClientApp, it is a part of " + ClientApp.class.getModule(); }

  public static void main(String args[]) {
    System.out.println(new ClientApp().getInfo());
    System.out.println(new FirstApi().getInfo());
  }
}