package com.it;

public class MyTest {
    public static void main(String[] args) {
        String microName = getMicroName("basicinfo");
        System.out.printf(microName);
    }

    public static String getMicroName(String micro){
        String microName=micro;
        String prefixName ="Src/";
        if (prefixName!=null){
            microName=prefixName+micro;
        }
        return microName;
    }
}
