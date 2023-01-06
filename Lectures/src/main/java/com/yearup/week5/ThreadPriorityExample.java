package com.yearup.week5;

import java.lang.*;

public class ThreadPriorityExample implements  Runnable {

    public void run()
    {
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args)
    {
        ThreadPriorityExample tpe = new ThreadPriorityExample();
        Thread t1 = new Thread(tpe, "First Thread");
        Thread t2 = new Thread(tpe, "Second Thread");
        Thread t3 = new Thread(tpe, "Third Thread");

        t1.setPriority(1); // Setting the priority of first thread.
        t2.setPriority(1); // Setting the priority of second thread.
        t3.setPriority(8); // Setting the priority of third thread.

        t1.start();
        t2.start();
        t3.start();
    }
}


