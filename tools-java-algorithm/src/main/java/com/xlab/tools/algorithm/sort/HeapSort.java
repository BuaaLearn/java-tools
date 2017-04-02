/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 * 堆排序
 * 使用最大堆进行从小到大进行排序，每次第一个元素为最大，依次最小，直到最后一个排序完。
 * 堆排序关键是是初始堆构建和一个元素替换后的堆调整，核心还是在于堆调整。
 * </p>
 * @author towan  
 */
public class HeapSort {

    void heapSort(int []arr){
        System.out.println("init build max heap..");
        //1.初始堆
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            adjustHeap(arr, n/2-i-1, n-1);//从后面的n/2-1调整走，调整到第0个元素
            System.out.println("build-pass["+i+"]:"+Arrays.toString(arr));
        }
        System.out.println("build-after:"+Arrays.toString(arr));
        
        //2.堆排序
        for(int i=1;i<n;i++){
            //交换出最后一个当前元素和堆最后一个元素
            swap(arr, 0, n-i);
            adjustHeap(arr, 0, n-i-1);//元素不断再减小
            System.out.println("sort-pass["+i+"]:"+Arrays.toString(arr));
        }
    }

    
    /**
     * 堆调整（元素不断换，换到左子树调整左子树，换到右子树调整右子树）
     * @param arr 原始数组
     * @param i 当前堆的根节点
     * @param n 堆的长度
     */
    void adjustHeap(int[] arr, int i, int n) {

        int tmp = arr[i];
        
        int j = i*2+1;//当前节点的左孩子
        while(j<=n){//=
            
            //右孩子比左孩子大，选择右孩子
            if(j<n && arr[j]<arr[j+1]){
                j++;
            }
            
            //如果满足堆，那么就要退出
            if(tmp >= arr[j]){//=
                break;
            }
            
            //右孩子或者左孩子换上去
            if(j%2==0){//右孩子替换上去
                arr[j/2-1] = arr[j];
            }else{//左孩子替换
                arr[j/2] = arr[j];
            }
            
            arr[j] = tmp;//儿子节点需要将值放回
            //调整右子树或者左子树
            j = j*2+1;
        }
        
    }
    
    /**
     * 元素交换
     */
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
