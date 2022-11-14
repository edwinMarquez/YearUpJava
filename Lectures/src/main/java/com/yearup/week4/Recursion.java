package com.yearup.week4;

import com.google.common.base.Stopwatch;
import com.yearup.ElaspsedTimer;

import java.util.HashMap;
import java.util.Map;

public class Recursion {
    long recFibonacci(int n) {
        if (n <= 1) return n;
        return recFibonacci(n - 1) + recFibonacci(n - 2);
    }

    long linFibonacci(int n) {
        long low = 0;
        long high = 1;
        for (int i = 0; i < n; i++) {
            long oldHigh = high;
            high = low + high;
            low = oldHigh;
        }
        return low;
    }

    // 0, 1, 1, 2, 3, 5
    //fib(4) -> fib(3) -> fib(2) -> fib(1) -> 1
    //first = 1
    long tailFibonacci(long n, long low, long high) {
        if (n == 0)
            return low;
        if (n == 1)
            return high;
        return tailFibonacci(n - 1, high, low + high);
        //n=4, fib(4,0,1) -> fib(3, 1, 1) -> fib(2, 1, 2) -> fib(1, 2, 3) -> 3
    }

    static Map<Long, Long> m = new HashMap<>();

    long memoizedFibonacci(long n) {
        if (m.get(n) == null) {
            m.put(n, memoizedFibonacci(n - 1) + memoizedFibonacci(n - 2));
        }
        return m.get(n);
    }

    public static void main(String[] args) {
        m.put(0L, 0L);
        m.put(1L, 1L);
        Recursion fib = new Recursion();
        ElaspsedTimer timer = new ElaspsedTimer();

        timer.start();
        System.out.println("recFibonacci: "+fib.recFibonacci(50));
        timer.stop("recFibonacci");

        timer.start();
        System.out.println("memoizedFibonacci: "+fib.memoizedFibonacci(50));
        timer.stop("memoizedFibonacci");

        timer.start();
        System.out.println("linFibonacci: "+fib.linFibonacci(50));
        timer.stop("linFibonacci");

        timer.start();
        System.out.println("tailFibonacci: "+fib.tailFibonacci(50, 0, 1));
        timer.stop("tailFibonacci");
    }
}
