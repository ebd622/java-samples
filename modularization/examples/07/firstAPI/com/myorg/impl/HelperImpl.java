package com.myorg.impl;

import com.myorg.first.Helper;

public class HelperImpl implements Helper {
    @Override
    public String greet() {
        return "Hello from HelperImpl";
    }
    public String secret() {
        return "se...t";
    }
}
