package com.xlab.tools.algorithm.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class HeapSortTest {

    HeapSort test = new HeapSort();
    @Test
    public void test() {
        int arrs[] = new int[]{1, 5,3,7,9,12,4,6,2};//第一个位置是分割点
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.heapSort(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{1, 2,3,4,5,6,7,9,12};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test2() {
        int arrs[] = new int[]{8, 5,3,7,9,12,4,6,2};
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.heapSort(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{2,3,4,5,6,7,8,9,12};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test3() {
        int arrs[] = new int[]{8, 5,3,7,9,12,4,6,2,8};
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.heapSort(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{2,3,4,5,6,7,8,8,9,12};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test4() {
        int arrs[] = new int[]{26, 5, 77, 1, 61, 11, 59, 15, 48, 19};
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.heapSort(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{1, 5, 11, 15, 19, 26, 48, 59, 61, 77};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test5() {
        int arrs[] = new int[]{26, 5, 77, 1, 61, 11,92, 59, 15, 48, 19};
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.heapSort(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{1, 5, 11, 15, 19, 26, 48, 59, 61, 77,92};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test_adjust(){
        int arrs[] = {41,23,18,20,19,36,4,12};
        System.out.println("adjust before:"+Arrays.toString(arrs));
        test.adjustHeap(arrs, 2, arrs.length-1);
        int expecteds[] = new int[]{41, 23, 36, 20, 19, 18, 4, 12};
        System.out.println("adjust after:"+Arrays.toString(arrs));
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test_adjust2(){
        int arrs[] = {26, 5, 77, 1, 61, 11, 59, 15, 48, 19};
        System.out.println("adjust before:"+Arrays.toString(arrs));
        test.adjustHeap(arrs, 3, arrs.length-1);
        System.out.println("adjust after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{26, 5, 77, 48, 61, 11, 59, 15, 1, 19};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
        
    }
    
    @Test
    public void test_adjust3(){
        int arrs[] = {26, 5, 77, 48, 61, 11, 59, 15, 1, 19};
        System.out.println("adjust before:"+Arrays.toString(arrs));
        test.adjustHeap(arrs, 2, arrs.length-1);
        System.out.println("adjust after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{26, 5, 77, 48, 61, 11, 59, 15, 1, 19};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
        
    }
    
    @Test
    public void test_adjust4(){
        int arrs[] = {26, 5, 77, 48, 61, 11, 59, 15, 1, 19};
        System.out.println("adjust before:"+Arrays.toString(arrs));
        test.adjustHeap(arrs, 1, arrs.length-1);
        System.out.println("adjust after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{26, 61, 77, 48, 19, 11, 59, 15, 1, 5};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
        
    }
    
    @Test
    public void test_adjust5(){
        int arrs[] = {26, 61, 77, 48, 19, 11, 59, 15, 1, 5};
        System.out.println("adjust before:"+Arrays.toString(arrs));
        test.adjustHeap(arrs, 0, arrs.length-1);
        System.out.println("adjust after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{77, 61,  59, 48, 19, 11, 26, 15, 1, 5};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
        
    }
}
