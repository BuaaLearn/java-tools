package com.xlab.tools.algorithm.graph;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ShortPathDijstraTest {
    int INF = Integer.MAX_VALUE;
    
    @Test
    public void test() {
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        ShortPathDijstra shortPath = new ShortPathDijstra(matrix);

        int vex_len = matrix.length;
        int[] prev = new int[vex_len];
        int[] dist = new int[vex_len];
        
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        shortPath.dijkstra(3, prev, dist);
        System.out.println("shortest path:"+Arrays.toString(dist));
        System.out.println("prev:"+Arrays.toString(prev));
        int[] expecteds = {22, 13, 3, 0, 4, 6, 12};
        assertArrayEquals("shortest dist fail ", expecteds , dist);
    }
    
    @Test
    public void test2() {//算法设计与分析的例子
        int matrix[][] = {
                {0,10,INF,30,100},
                {10,0,50,INF,INF},
                {INF, 50,0,20,10},
                {30,INF,20,0,60},
                {100,INF,10,60,0}};
        ShortPathDijstra shortPath = new ShortPathDijstra(matrix);

        int vex_len = matrix.length;
        int[] prev = new int[vex_len];
        int[] dist = new int[vex_len];
        
        // dijkstra算法获取"第0个顶点"到其它各个顶点的最短距离
        shortPath.dijkstra(0, prev, dist);
        System.out.println("shortest path:"+Arrays.toString(dist));
        System.out.println("prev:"+Arrays.toString(prev));
        int[] expecteds = {0, 10, 50, 30, 60};
        assertArrayEquals("shortest dist fail ", expecteds , dist);
    }
    
    @Test
    public void test3() {//唐发根数据结构教程的例子
        int matrix[][] = {
                {0,   10,  2,   INF, INF, INF, INF},
                {10,  0,   INF, INF, 1,   INF, INF},
                {2,   INF, 0,   2,   INF, 11,  INF},
                {INF, INF, 2,   0,   4,   6,   INF},
                {INF, 1,   INF, 4,   0,   INF, 7},
                {INF, INF, 11,  6,   INF, 0,   3},
                {INF, INF, INF, INF, 7,   3,   0}};
        ShortPathDijstra shortPath = new ShortPathDijstra(matrix);

        int vex_len = matrix.length;
        int[] prev = new int[vex_len];
        int[] dist = new int[vex_len];
        
        // dijkstra算法获取"第0个顶点"到其它各个顶点的最短距离
        shortPath.dijkstra(0, prev, dist);
        System.out.println("shortest path:"+Arrays.toString(dist));
        System.out.println("prev:"+Arrays.toString(prev));
        int[] expecteds = {0, 9, 2, 4, 8, 10, 13};
        assertArrayEquals("shortest dist fail ", expecteds , dist);
    }

}
