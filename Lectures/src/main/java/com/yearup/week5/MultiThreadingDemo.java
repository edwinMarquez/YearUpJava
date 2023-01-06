package com.yearup.week5;

//Approach #1
class MyThread extends Thread
{
   public void run()
    {
        //Task of the Thread
        for (int i=0;i<10;i++)
        {
            System.out.println("Child Thread");
        }
    }

    /*public void start()
    {
        super.start();
        System.out.println("Overiding start is not a good idea;");
    }*/
}

//Approach #2

class MyRunnable implements Runnable    {

    public void run(){

        //Task of the Thread
        for (int i=0;i<10;i++)
        {
            System.out.println("Child Thread(MJ) from Runnable interface");
        }

    }
}


public class MultiThreadingDemo {

    public static void main(String args[])
    {
       MyThread t1 = new MyThread();
       t1.start();
        //t1.start(); //This wil throw IllegalThreadStateException
        //t1.run();

       for (int i=0;i<10;i++)
        {
            System.out.println("Main Thread");
        }

        t1.setPriority(Thread.MIN_PRIORITY);

      /* MyRunnable r = new MyRunnable();
        Thread t2 = new Thread(r);/// r represents Target Runnable
        t2.start();
        //getting & setting Thread names
       System.out.println("Thread name is "+Thread.currentThread().getName());
        Thread.currentThread().setName("Michael Jackson");
        System.out.println("Thread name is "+Thread.currentThread().getName());

        //Setting Thread Priorities
        t2.setPriority(Thread.MIN_PRIORITY);*/

        //1 MIN_PRIORITY
        //5 NORM_PRIORITY
        //10 MAX_PRIORITY

    }



}