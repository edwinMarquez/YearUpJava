package com.yearup.week4.code.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateTest {

    Duplicate d = new Duplicate();

    @Test
    void isUnique1_whenEmpty_returnsTrue() {
        int[] empty = {};
        boolean out = d.isUnique1(empty);
        assertTrue(out);
    }
    @Test
    void isUnique1_whenNoDup_returnsTrue() {
        int[] arr = {1,2,3,6,4};
        boolean out = d.isUnique1(arr);
        assertTrue(out);
    }
    @Test
    void isUnique1_whenOneDup_returnsFalse() {
        int[] arr = {1,2,3,4,3};
        boolean out = d.isUnique1(arr);
        assertFalse(out);
    }
    @Test
    void isUnique1_whenMoreDup_returnsFalse() {
        int[] arr = {1,2,3,2,1};
        boolean out = d.isUnique1(arr);
        assertFalse(out);
    }
    @Test
    void isUnique2_whenEmpty_returnsTrue() {
        int[] empty = {};
        boolean out = d.isUnique2(empty);
        assertTrue(out);
    }
    @Test
    void isUnique2_whenNoDup_returnsTrue() {
        int[] arr = {1,2,3,6,4};
        boolean out = d.isUnique2(arr);
        assertTrue(out);
    }
    @Test
    void isUnique2_whenOneDup_returnsFalse() {
        int[] arr = {1,2,3,4,3};
        boolean out = d.isUnique2(arr);
        assertFalse(out);
    }
    @Test
    void isUnique2_whenMoreDup_returnsFalse() {
        int[] arr = {1,2,3,2,1};
        boolean out = d.isUnique2(arr);
        assertFalse(out);
    }
}