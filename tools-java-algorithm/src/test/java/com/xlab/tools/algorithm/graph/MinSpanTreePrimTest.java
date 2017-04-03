package com.xlab.tools.algorithm.graph;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MinSpanTreePrimTest {
    
    int INF = Integer.MAX_VALUE;
    
    @Test
    public void test() {//运筹学的例子
        int matrix[][] = {
                {0,   2,   INF, 7,   INF, 2,  INF},
                {2,   0,   1,   5,   3,   5,  INF},
                {INF, 1,   0,   INF, 4,   4,  INF},
                {7,   5,   INF, 0,   1,   INF,5},
                {INF, 3,   4,   1,   0,   INF, 7},
                {2,   5,   4,   INF, INF, 0,   INF},
                {INF, INF, INF, 7,   7,   INF,   0}};
        
        MinSpanTreePrim mst = new MinSpanTreePrim(matrix);
        int []mstArr = new int [matrix.length];
        int sum = mst.prim(0,mstArr );
        
        //min应该是14
        System.out.println("生成路径顺序为:"+Arrays.toString(mstArr));
        int[] expecteds = {0, 1, 2, 5, 4, 3, 6};
        assertArrayEquals(expecteds , mstArr);
        System.out.println("sum:"+sum);
        assertEquals("fail to MST-weight", 14, sum );
      
    }
    
    @Test
    public void test2() {//算法设计与分析的例子
        int matrix[][] = {
                 {0,   6,   1,   5,   INF,  INF},
                {6,   0,   5, INF,   3,  INF},
                {1,   5, 0,   INF,   6,4},
                {5,   INF,   INF,   0,   INF, 2},
                {INF,   3,   6, INF, 0,   6},
                {INF, INF, 4,   2,   6,   0}};
        
        MinSpanTreePrim mst = new MinSpanTreePrim(matrix);
        int []mstArr = new int [matrix.length];
        int sum = mst.prim(0,mstArr );
        
        //min应该是15
        System.out.println("生成路径顺序为:"+Arrays.toString(mstArr));
        int[] expecteds = {0, 2, 5, 3, 1, 4};
        assertArrayEquals(expecteds , mstArr);
        System.out.println("sum:"+sum);
        assertEquals("fail to MST-weight", 15, sum );
      
    }

}
