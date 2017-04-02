package com.xlab.tools.algorithm.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {
    
    MergeSort mergeSort = new MergeSort();
    @Test
    public void test() {
        int arr[] = {1,3,5,7,9};
        int brr[] = {2,4,6,8,10};
        int[] crr = mergeSort.mergeSort(arr, brr);
        System.out.println("crr:"+Arrays.toString(crr));
        int []expecteds = {1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals("assert fail", expecteds, crr);
    }
    
    @Test
    public void test2() {
        int arr[] = {1,3,5,7,9,20,21};
        int brr[] = {2,4,6,8,10};
        int[] crr = mergeSort.mergeSort(arr, brr);
        System.out.println("crr:"+Arrays.toString(crr));
        int []expecteds = {1,2,3,4,5,6,7,8,9,10,20,21};
        assertArrayEquals("assert fail", expecteds, crr);
    }

}
