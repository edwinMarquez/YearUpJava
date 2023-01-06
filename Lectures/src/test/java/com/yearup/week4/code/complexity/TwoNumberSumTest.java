package com.yearup.week4.code.complexity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


public class TwoNumberSumTest {
    @Test
    void testTargetTwoNumberSumOn2() {
        int arr[] = {3,5,-4,8,11,1,-1,6};
        int target=15;
        int expArr[] = {5,8};
        int actArr[] = TwoNumberSum.targetTwoNumberSumOn2(arr,13);
        boolean out = Arrays.equals(expArr, actArr);
        assertTrue(out);
    }
   /* @Test
    void targetTwoNumberSumOn() {
        int arr[] = {3,5,-4,8,11,1,-1,6};
        int target=15;
        int expArr[] = {5,8};
        int actArr[] = TwoNumberSum.targetTwoNumberSumOn(arr,13);
        boolean out = Arrays.equals(expArr, actArr);
        assertTrue(out);
    }
    @Test
    void targetTwoNumberSumnlogn() {
        int arr[] = {3,5,-4,8,11,1,-1,6};
        int target=15;
        int expArr[] = {5,8};
        int actArr[] = TwoNumberSum.targetTwoNumberSumOn(arr,13);
        boolean out = Arrays.equals(expArr, actArr);
        assertTrue(out);
    }*/
}
