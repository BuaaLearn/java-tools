package com.xlab.tools.algorithm.linkedlist;


import org.junit.Test;

public class ReverseListNodeTest {

    @Test
    public void testReverse() {
        ReverseListNode reverseList = new ReverseListNode();
        ListNode node = createNode();
        prettyPrint(node);
        System.out.println();
        ListNode reverse = reverseList.reverse(node );
        prettyPrint(reverse);
    }

    /**
     * @param node
     */
    private void prettyPrint(ListNode node) {
        ListNode p = node;
        while(p!=null){
            System.out.print(p.val+"\t");
            p = p.next;
        }
        
    }

    /**
     * @return
     */
    private ListNode createNode() {
        ListNode node = new ListNode(3);
        
        ListNode listNode = new ListNode(4);
        node.next = listNode;
        ListNode listNode2 = new ListNode(5);
        listNode.next  = listNode2;
        
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        
        listNode3.next = new ListNode(7);
        return node;
    }

}
