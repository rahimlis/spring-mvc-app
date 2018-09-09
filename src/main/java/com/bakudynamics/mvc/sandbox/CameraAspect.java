package com.bakudynamics.mvc.sandbox;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CameraAspect {

    @Pointcut("execution(int Camera.snap(..))")
    private void cameraSnap() {

    }

    @Before("cameraSnap()")
    public void beforeSnap() {
        System.out.println("in Before");
    }


    /**
     * Gets executed regardless of exceptions thrown inside the method body
     * resembles behaviour of finally in try-catch-finally block
     */
    @After("cameraSnap()")
    public void afterSnap() {
        System.out.println("in After");
    }

    /**
     * Gets executed only if the method body executed and successfully returned
     * a value (executed without exceptions)
     */
    @AfterReturning("cameraSnap()")
    public void afterSnapReturning() {
        System.out.println("in AfterReturning");
    }

    @Around("cameraSnap()")
    public Object aroundSnap(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("in around (before)");

        long tic = System.currentTimeMillis();
        int ret = 1618;
        try {
            ret = (int) proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("in around handling exception: " + throwable.getMessage());
        }

        System.out.println("in around (after)");

        long tac = System.currentTimeMillis();

        System.out.println("time of execution: " + (tac - tic));

        return ret;
    }

}
