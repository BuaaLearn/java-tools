/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.sort;

/**
 * <p>
 * 递归的快速排序方法
 * 核心思想：
 * 每一轮针对一个划分点s(起点),需要一直让左边的数小于s,右边的数大于s.
 * 设置两个变量i=s+1,j=t,while(i<j)保持找到第一个arr[s]<arr[i],找到第一个arr[s]>arr[j],交换i-j元素，
 * 直到跳出循环，分割点和第二指针进行交换，随后再次递归下去。
 * </p>
 * @author towan  
 */
public class QuickSortRecurisive {
    
    public void quickSortRec(int []arr){
        int s = 0;
        int t = arr.length-1;
        quickSort(arr, s, t);
    }

    /**
     * 针对起点和终点进行快排
     * @param arr
     * @param s
     * @param t
     */
    private void quickSort(int[] arr, int s, int t) {
        
        if(s<t){//递归判断边界
            int i = s+1;
            int j = t;

            while(true){//不能是i<j
                
                //第一指针查找不合符划分位置的第一个点
                while(i <t && arr[s] > arr[i]){//不能取等于
                    i++;
                }
                //第二指针查找不合符划分的第二个点
                while(j>s && arr[s] < arr[j]){
                    j--;
                }
                
                // 交换不合符的第一个点
                if(i<j){
                    System.out.println("pos-i:"+i+",pos-j:"+j+",swap element:a[i]:"+arr[i]+",arr[j]:"+arr[j]);
                    swap(arr, i, j);
                }else{
                    break;
                }
                
            }
            // 交换划分点到正确位置
            swap(arr, s, j);
            
            // 递归处理前半段和后半段
            quickSort(arr, s, j-1);
            quickSort(arr, j+1, t);
        }
    }

    /**
     * 位置进行交换
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
