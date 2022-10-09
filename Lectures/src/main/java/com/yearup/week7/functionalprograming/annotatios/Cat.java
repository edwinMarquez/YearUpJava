package com.yearup.week7.functionalprograming.annotatios;


import java.security.SecureRandom;

@Describe("Describes a cat")
public class Cat {

    @Describe("holds the name of the cat")
    public String name;
    @Describe("holds the amount of cookies currently on it's belly")
    public int cookies;

    @Describe("Tries and gives a name to the cat")
    public void giveName(String name){
        byte[] newname = new byte[20];
        new SecureRandom().nextBytes(newname);
        this.name = String.valueOf(newname);
    }

    @Describe("Give a cookie to the that")
    public void giveCookie(){
        cookies++;
    }

    @Override
    public String toString(){
        return "name: "+ name + " cookies: " + cookies;
    }

}
