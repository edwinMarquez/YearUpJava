package com.yearup.week5;

// Java program to illustrate
// sleep() method in Java

import java.lang.*;

public class SleepDemo implements Runnable {
    Thread t;
    public void run()
    {
        for (int i = 0; i < 4; i++) {
            System.out.println(
                    Thread.currentThread().getName() + " "
                            + i);
            try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(5000);
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Thread t = new Thread(new SleepDemo());

        // call run() function
        t.start();

        Thread t2 = new Thread(new SleepDemo());

        // call run() function
        t2.start();
    }
}

