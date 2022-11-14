package com.yearup.week4.code.arrays;

import java.util.Arrays;

public class Duplicate {
    /**
     * @param data the input int array
     * @return true if the array has all unique elements
     * This is O(n^2) solution
     */
    public boolean isUnique1(int[] data) {
        for (int i = 0; i < data.length - 1; i++)
            for (int j = i + 1; j < data.length; j++)
                if (data[j] == data[i])
                    return false;
        return true;
    }

    /**
     * @param data the input int array
     * @return true if the array has all unique elements
     * This is O(nlongn) solution
     */
    public boolean isUnique2(int[] data) {
        Arrays.sort(data);
        for(int j=0;j<data.length-1;j++){
            if(data[j] == data[j+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Duplicate d = new Duplicate();
        int[] list = {3,4,5,2,1};
        System.out.println(d.isUnique2(list));
        //NOTE that the list here does get modified outside isUnique2 method
        System.out.println(Arrays.toString(list));
    }
}
