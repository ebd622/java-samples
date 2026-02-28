package com.myorg.client;

import com.myorg.first.FirstApi;
import com.myorg.first.Helper;
import java.lang.reflect.Method;

//import com.myorg.impl.HelperImpl; //ERROR at compile time even though it is available now for runtime

class ClientApp {
  public String getInfo() { return "This is ClientApp, it is a part of " + ClientApp.class.getModule(); }

  public static void main(String args[]) throws Exception {
    System.out.println(new ClientApp().getInfo());
    System.out.println(new FirstApi().getInfo());

//    Helper h = new HelperImpl(); //Error: Cannot access com.myorg.impl.HelperImpl
//    System.out.println(h);

    System.out.println("---Accessing Helper class and its methods");
    Helper helper = new FirstApi().getHelper();
    System.out.println(helper);
    System.out.println(helper.greet()); //works fine

    System.out.println("---Accessing secret() method via reflection");
    Method method = helper.getClass().getMethod("secret");
    System.out.println(method);
    System.out.println(method.invoke(helper)); //Not it is allowed at runtime because the package "com.myorg.impl" is opened
  }
}