package com.myorg.app;

import com.myorg.first.FirstApi;

class Application {
  public String getInfo() { return "This is Application"; }

  public static void main(String args[]) {
    System.out.println(new Application().getInfo());
    System.out.println(new FirstApi().getInfo());
  }
}

