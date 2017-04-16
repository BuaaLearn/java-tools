/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.linkedlist;

/**
 * <p>
 * 链表节点
 * </p>
 * @author towan  
 */
public class ListNode {
    public int val; //为了测试暂时使用这样不好的风格
    public ListNode next;
    /**
     * @param val
     */
    public ListNode(int val) {
        super();
        this.val = val;
    }
    
    public ListNode appendToNext(int n){
        ListNode listNode = new ListNode(n);
        this.next = listNode;
        return listNode;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "val:"+val;
    }
    public boolean equals(ListNode obj) {
        return obj.hashCode()==this.hashCode();
//      return super.equals(obj);
    }
}
