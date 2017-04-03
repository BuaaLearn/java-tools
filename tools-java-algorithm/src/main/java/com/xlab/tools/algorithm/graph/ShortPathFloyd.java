/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.graph;

/**
 * <p>
 * 多源最短的Floyd实现
 * </p>
 * @author towan  
 */
public class ShortPathFloyd {
    
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    private int mat[][];//原始图
    
    public ShortPathFloyd(int[][] mat) {
        super();
        this.mat = mat;
    }
    
    /*
     * floyd最短路径。统计图中各个顶点间的最短路径。
     *
     * 参数说明：
     *     path -- 路径。 path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
     *     dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
     */
    public void floyd(int[][] path, int[][] dist) {
        int vec_len = path.length;
        
        // 初始化
        for (int i = 0; i < vec_len; i++) {
            for (int j = 0; j < vec_len; j++) {
                dist[i][j] = mat[i][j];    // 初始为直连的距离
                path[i][j] = j;                //初始设置i-j经过的最短路径是经过j。
            }
        }

        // 计算最短路径
        for (int k = 0; k < vec_len; k++) {//O(n^3)
            
            for (int i = 0; i < vec_len; i++) {
                for (int j = 0; j < vec_len; j++) {

                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);// 外层任意节点
                    
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];//记录经历K
                    }
                    
                }
            }
        
        }
       
    }
}
