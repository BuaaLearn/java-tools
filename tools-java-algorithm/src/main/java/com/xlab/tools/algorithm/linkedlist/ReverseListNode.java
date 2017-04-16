/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.linkedlist;

/**
 * <p>
 * 反转单链表
 * </p>
 * @author towan  
 */
public class ReverseListNode {
    
    /**
     * 链表节点的反转，注意不要断裂
     * 
     * a->b-----h->i->j.....
     * a<-b-----h<-i  j...
     * @param node
     * @return
     */
    public ListNode reverse(ListNode node){
        ListNode r = node;
        ListNode p = node;//当前
        ListNode q = null;//上一个
        
        while(p!=null){
            ListNode tmp = p.next;//保存节点j
            
            if(tmp==null){//结尾了，找到头结点了
                r = p;
            }
            
            p.next = q;//拼接
            q = p;
            p = tmp;
        }
        return r;
    }
}
