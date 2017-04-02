/*
777 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.graph;

/**
 * <p>
 * 单源最短路
 * Dijstra（迪杰斯特拉）算法。
 * 使用了四个结构。记录标记的使用每点代表最短路径
 * dist_u={dist_c+a[c][u]}
 * TODO BUG CONTAINS
 * </p>
 * @author towan  
 */
public class ShortPath {
    
    /**
     * Dijstra（迪杰斯特拉）最短路算法
     * @param v 出发节点
     * @param a 边的权值，不连接为大数字
     * @param dist 源节点到各个顶点的最短路
     * @param prev 从源到顶点的最短路径的前一个节点，用于查找最短路径
     */
    void dijstra(int v, double [][]a, double[] dist, int []prev){
        int n = dist.length;
        if(v<0 || v>n-1){//从1开始
            return;
        }
        //标记节点是否已经求得最短路
        boolean []s = new boolean[n];
        
        //初始化
        for(int i=0;i<n;i++){
            s[i] = false;//每个节点未求得最短路
            dist[i] = a[v][i];
            if(dist[i]==Double.MAX_VALUE){
                prev[i] = 0;
            }else{
                prev[i] = v;
            }
        }
        
        dist[v] = 0;
        s[v] = true;
        
        for(int i=0;i<n-1;i++){
            
            double tmp = Double.MAX_VALUE;
            int u = v;
            
            for(int j=0;j<=n-1;j++){
                
                if(!s[j] && dist[j]<tmp){
                    u = j;
                    tmp = dist[j];
                }
            }
            s[u] = true;
            for(int j=0;j<=n-1;j++){
                if(!s[j] && a[u][j]<Double.MAX_VALUE){
                    double newDist = dist[u]+a[u][j];
                    
                    if(newDist<dist[j]){
                        //dist[j]减少，选择最小的
                        dist[j] = newDist;
                        prev[j] = u;
                    }
                }
            }
            
        }
        
    }
}
