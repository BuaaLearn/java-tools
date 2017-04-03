/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.graph;

/**
 * <p>
 * Djstras算法-邻接矩阵的实现方式
 * 算法的核心思想是：
 * 使用两个集合，一个集合S记录源点到已访问的最短路径，另外一个集合U记录未访问节点的最短路径，
 * 而访问和未访问使用同一个最短路数组实现，只是使用了标记数据进行了标记，为了求得最短路径，需要使用数组记录到达最短路时的前驱节点。
 * 
 * 操作步骤：
 * 1.初始步。初始S为源点，U为其它点，prev都是设置为0。
 * 2.最短路寻找步（n-1次）。每次在U中找到最短路对应的下标位置，然后放入到S中，更新U，查找U最小加入到S。。。
 * </p>
 * @author towan  
 */
public class ShortPathDijkstra {

    private int[][] mat;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    
    /**
     * 最短路图的构建
     * @param vexs 顶点名称
     * @param matrix 图的权值
     */
    public ShortPathDijkstra(int[][] matrix) {
        this.mat = matrix;
    }

    /*
     * Dijkstra最短路径,计算从顶点vs到各个顶点的最短路
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        int vex_len = mat.length;
        
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[vex_len];
        
        // 初始化
        for (int i = 0; i < vex_len; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。默认是
            prev[i] = 0;              // 顶点i的前驱顶点为0。是否存在问题？FIXME 是否是与真实的零冲突
            dist[i] = mat[vs][i]; // U部分初始，U和S区分通过flag数组
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;//默认是

        // 遍历vex_len-1次；每次找出一个顶点的最短路径。
        for (int step = 0; step < vex_len-1; step++) {
            int idx=0; // 每次找顶点的时候设置 是否存在问题？FIXME
            
            // 寻找当前最小的路径；
            int min = INF;
            for (int j = 0; j < vex_len; j++) {
                if (flag[j]==false && dist[j]<min) {// 在U部分找出里源点的最短路径的顶点
                    min = dist[j];
                    idx = j;
                }
            }
            
            // 标记"顶点k"为已经获取到最短路径
            flag[idx] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < vex_len; j++) {
                
                int tmp = (mat[idx][j]==INF ? INF : (min + mat[idx][j]));//key point
                if (flag[j]==false && (tmp<dist[j]) ) {//更新U部分的前驱及距离（因为直接i-j不是最短）
                    dist[j] = tmp;
                    prev[j] = idx;
                }
                
            }
            
        }
    }
    
}
