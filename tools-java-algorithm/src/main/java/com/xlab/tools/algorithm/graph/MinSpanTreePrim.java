/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.graph;

/**
 * <p>
 * 最小生成树的prim解法。
 * 最优性质为：如果图中的边权值最小，那么MST一定包含。而PRIM采用的避圈法不断加入剩余最小。
 * 类似于Dijkstra的思想，使用一个集合S，不同增加顶点达到另外一个集合U的总数。
 * 计算最小的过程依赖于两个数组
 * </p>
 * @author towan  
 */
public class MinSpanTreePrim {
    
    private static final int INF = Integer.MAX_VALUE;   // 最大值
    
    private int [][]mat;//图中权值
    private int []mVexs;//顶点编号
    
    public MinSpanTreePrim(int[][] mMatrix) {
        super();
        this.mat = mMatrix;
        int len = mMatrix.length;
        
        mVexs = new int[len];
        for(int i=0;i<len;i++){//从0开始编号
            mVexs[i] = i;
        }
        
    }

    /**
     *  prim最小生成树
     * @param start -- 从图中的第start个元素开始，生成最小树
     * @param mstArr -- 最小生成数组顺序
     * @return 生成树权值
     */
    public int prim(int start, int[] mstArr) {
        int num = mVexs.length;         // 顶点个数
        int index = 0;                    // prim最小树的索引，即mstArr数组的索引
        int[] weights = new int[num];   // 顶点间边的权值

        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
        mstArr[index++] = mVexs[start];

        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (int i = 0; i < num; i++ ){
            weights[i] = mat[start][i];
        }
        
        // 将第start个顶点的权值初始化为0。
        // 可以理解为"第start个顶点到它自身的距离为0"。
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
            if(start == i){
                continue;
            }

            int j = 0;
            int k = 0;
            int min = INF;
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
            while (j < num) {
                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            mstArr[index++] = mVexs[k];
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[k] = 0;
            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
            for (j = 0 ; j < num; j++) {
                // 当第j个节点没有被处理，并且需要更新时才被更新。
                if (weights[j] != 0 && mat[k][j] < weights[j]){
                    weights[j] = mat[k][j];
                }
            }
        }

        // 计算最小生成树的权值
        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            // 获取prims[i]在mMatrix中的位置
            int n = getPosition(mstArr[i]);
            // 在vexs[0...i]中，找出到j的权值最小的顶点。
            for (int j = 0; j < i; j++) {
                int m = getPosition(mstArr[j]);
                if (mat[m][n]<min){
                    min = mat[m][n];
                }
            }
            sum += min;
        }
        return sum;
    }
    
    /*
     * 返回ch位置
     */
    private int getPosition(int ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch){
                return i;
            }
        return -1;
    }

}
