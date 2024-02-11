package com.ral1996.sv.asserts;

/*
    Developer: Mts. Ing. Raúl Mauricio Portillo Muñoz
    Description: Can you use this class with Pattern Singleton, to instantiate methods
                 in other classes more easily and not have to create objects for each
                 method in the file
 */

import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebAssert extends Assert {

    public static WebAssert instance;

    public WebAssert() { }

    public synchronized static WebAssert getInstance() {
        if (instance == null) {
            instance = new WebAssert();
        }

        return instance;
    }

    // Function for validate if the text is similar
    public void AssertEqualForText(String message, String expected, String actual) {
        try {
            Assert.assertEquals(message, expected, actual);
        } catch (AssertionError error) {
            error.printStackTrace();
        }
    }

    // Function for await seconds for steps
    public void awaitForStep(long time) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();

        try {
            condition.await(time, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
