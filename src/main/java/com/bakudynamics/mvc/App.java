package com.bakudynamics.mvc;

import com.bakudynamics.mvc.sandbox.Camera;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("sandbox.xml");
        Camera camera = (Camera) context.getBean("camera");

        int a = 0;

        try {
            a = camera.snap();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        System.out.println("a:" + a);

        camera.snap(99);
    }
}
