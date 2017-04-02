package com.xlab.tools.algorithm.graph;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ShortPathTest {
    
    ShortPath test = new ShortPath();
    
    @Test
    public void test() {
        double [][]a = {
                {0,30,Double.MAX_VALUE,30,100},
                {Double.MAX_VALUE,0,50,Double.MAX_VALUE,Double.MAX_VALUE},
                {Double.MAX_VALUE, 50,0,20,10},
                {30,Double.MAX_VALUE,20,0,60},
                {100,Double.MAX_VALUE,10,60,0}
        };
        int len = a.length;
        int v = 0;
        double[] dist = new double[len];
        int[] prev = new int[len];
        test.dijstra(v , a, dist , prev );
        System.out.println("prev:"+Arrays.toString(prev));
        int[] expecteds = {0, 3, 2, 4};
        assertArrayEquals(expecteds , prev);
    }

}
