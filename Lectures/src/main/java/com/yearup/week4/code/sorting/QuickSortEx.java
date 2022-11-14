package main.java.com.yearup.week4.code.sorting;

import java.io.*;
import java.util.*;

public class QuickSortEx {
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int pivot = arr[hi];
        int pidx = partition(arr, pivot, lo, hi);
        quickSort(arr, lo, pidx - 1);
        quickSort(arr, pidx + 1, hi);
    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

       public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printSortedArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int arr[] = {7,4,5,3,2,6,1};
        quickSort(arr, 0, arr.length - 1);
        printSortedArr(arr);
    }

}