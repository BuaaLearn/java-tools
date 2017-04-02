package com.xlab.tools.algorithm.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortRecurisiveTest {
    
    QuickSortRecurisive test = new QuickSortRecurisive();
    @Test
    public void test() {
        int arrs[] = new int[]{1, 5,3,7,9,12,4,6,2};//第一个位置是分割点
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.quickSortRec(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{1, 2,3,4,5,6,7,9,12};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test2() {
        int arrs[] = new int[]{8, 5,3,7,9,12,4,6,2};
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.quickSortRec(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{2,3,4,5,6,7,8,9,12};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }
    
    @Test
    public void test3() {
        int arrs[] = new int[]{8, 5,3,7,9,12,4,6,2,8};
        System.out.println("sort before:"+Arrays.toString(arrs));
        test.quickSortRec(arrs);
        System.out.println("sort after:"+Arrays.toString(arrs));
        int expecteds[] = new int[]{2,3,4,5,6,7,8,8,9,12};
        assertArrayEquals("arr equal fail...", expecteds, arrs);
    }

}
