/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.sort;

/**
 * <p>
 * 归并排序
 * 描述：给定两个有序数组，返回一个合并的有序数组。
 * 方法：
 * 设计两个变量u,v,开始进行合并，剩余部分进行复制。
 * </p>
 * @author towan  
 */
public class MergeSort {

    int [] mergeSort(int []arr, int []brr){
        int alen = arr.length;
        int blen = brr.length;
        
        int c[] = new int[alen+blen];
        
        int i = 0;//第一个数组开始位置
        int j = 0;//第二个数组开始位置
        int k = 0;//第三个数组开始位置
        
        //排序
        for(;i<alen && j<blen;){
            if(arr[i] < brr[j]){
                c[k++] = arr[i++];
            }else{
                c[k++] = brr[j++];
            }
        }
        
        //复制arr剩余部分
        while(i<alen){
            c[k++] = arr[i++];
        }
        
        //复制brr剩余部分
        while(j<blen){
            c[k++] = brr[j++];
        }
        
        return c;
    }
}
