package main.java.com.yearup.week4.code.sorting;

public class SelectionSortEx {
    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            int minPos = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            //swap
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void printSortedArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        System.out.println("Selection sort follows..");
        int arr[] = {7,4,5,3,2,6,1};
        selectionSort(arr);
        printSortedArr(arr);
    }
}
