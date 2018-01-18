package org.ruel;

import java.io.Serializable;

public class Hello implements Serializable{

    private String name;

    private Hello(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hello(String name){
        this.name = name;
    }
    private void printHello(){
        System.out.println("Hello " + this.name);
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
