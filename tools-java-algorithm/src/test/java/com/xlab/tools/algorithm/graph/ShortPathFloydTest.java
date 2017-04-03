package com.xlab.tools.algorithm.graph;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ShortPathFloydTest {

    int INF = Integer.MAX_VALUE;
    
    
    @Test
    public void test2() {//运筹学的例子
        int matrix[][] = {
                {0,   5,   2,    INF, INF, INF, INF},
                {5,   0,   INF,  2,  7,   INF, INF},
                {2,   INF, 0,   7,   INF, 4,  INF},
                {INF, 2,   7,   0,   6,   2,   INF},
                {INF, 7,   INF, 6,   0,   1, 3},
                {INF, INF, 4,   2,   1, 0,   6},
                {INF, INF, INF, INF, 3,   6,   0}};
        
       ShortPathFloyd shortPath = new ShortPathFloyd(matrix);

       int vec_len = matrix.length;
       int[][] path = new int[vec_len][vec_len];
       int[][] dist = new int[vec_len][vec_len];
       
       // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
       shortPath.floyd(path, dist);
       
       // 打印floyd最短路径的结果
       for (int i = 0; i < vec_len; i++) {
          System.out.println(Arrays.toString(dist[i]));
       }
       
       System.out.println("path:");
       for (int i = 0; i < vec_len; i++) {
           System.out.println(Arrays.toString(path[i]));
        }
       
       
       int[][] expecteds={
               {0, 5, 2, 7, 7, 6, 10},
               {5, 0, 7, 2, 5, 4, 8},
               {2, 7, 0, 6, 5, 4, 8},
               {7, 2, 6, 0, 3, 2, 6},
               {7, 5, 5, 3, 0, 1, 3},
               {6, 4, 4, 2, 1, 0, 4},
               {10, 8, 8, 6, 3, 4, 0}
       };
       for(int i=0;i<vec_len;i++){
           assertArrayEquals("fail-"+i+"-pass",expecteds[i], dist[i]);
       }
       
       
       int[][] expectedsPath={
               {0, 1, 2, 1, 2, 2, 2},
               {0, 1, 0, 3, 3, 3, 3},
               {0, 0, 2, 5, 5, 5, 5},
               {1, 1, 5, 3, 5, 5, 5},
               {5, 5, 5, 5, 4, 5, 6},
               {2, 3, 2, 3, 4, 5, 4},
               {4, 4, 4, 4, 4, 4, 6}
       };
       for(int i=0;i<vec_len;i++){
           assertArrayEquals("fail-"+i+"-pass",expectedsPath[i], path[i]);
       }
    }

}
