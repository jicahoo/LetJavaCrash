package com.jicahoo.let.java.crash;

import com.jichao.letjavacrash.util.ClassLoadUtil;

public class Metaspace {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception{
        System.out.println(args[0]);
        ClassLoadUtil.loadFromFile(args[0]);
    }

    public static void useJavassist() throws Exception {
        for (long i = 0; ; i++) {
            Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
            System.out.println(i);
            Thread.sleep(10*1000);
        }
    }
}
