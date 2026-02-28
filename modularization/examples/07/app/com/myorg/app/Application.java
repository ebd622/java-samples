package com.myorg.app;

import com.myorg.client.ClientApi;
import com.myorg.client.Helper;
import java.lang.reflect.Method;

//import com.myorg.impl.HelperImpl; //ERROR at compile time even though it is available now for runtime

class Application {
  public String getInfo() { return "This is Application, it is a part of " + Application.class.getModule(); }

  public static void main(String args[]) throws Exception {
    System.out.println(new Application().getInfo());
    System.out.println(new ClientApi().getInfo());

//    Helper h = new HelperImpl(); //Error: Cannot access com.myorg.impl.HelperImpl
//    System.out.println(h);

    System.out.println("---Accessing Helper class and its methods");
    Helper helper = new ClientApi().getHelper();
    System.out.println(helper);
    System.out.println(helper.greet());

    System.out.println("---Accessing secret() method via reflection");
    Method method = helper.getClass().getMethod("secret");
    System.out.println(method);
    System.out.println(method.invoke(helper));
  }
}

