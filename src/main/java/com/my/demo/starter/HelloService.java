package com.my.demo.starter;

public class HelloService {
    private String message;

    public String sayHello() {
        return "Hello " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
