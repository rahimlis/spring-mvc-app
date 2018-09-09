package com.bakudynamics.mvc.sandbox;

import org.springframework.stereotype.Component;

@Component
public class Camera {

    public int snap() throws Exception {
        System.out.println("SNAP!");

        if (true)
            throw new Exception("Camera snap exception");

        return 25;
    }


    public void snap(int exp) {
        System.out.println("SNAP!" + exp);
    }


    public void zoom() {
        System.out.println("Zooming camera");
    }

}
