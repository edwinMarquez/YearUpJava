package com.yearup.week5;
 class YieldingThread extends Thread {

     public void run() {

        //Task of the Thread
        for (int i = 0; i < 100; i++) {
            Thread.yield();
            System.out.println("Child Thread");
        }
    }
}

class YieldDemo {

    public static void main(String[] args) {
        YieldingThread t = new YieldingThread();
        t.start();
        //t2.setPriority(Thread.MIN_PRIORITY);*
        Thread.currentThread().setPriority(1);
        for(int i=0;i<100;i++)
        {
            System.out.println("main thread");
        }
    }

}
