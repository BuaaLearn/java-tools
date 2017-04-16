/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.tree.traversal;


import org.junit.Test;

import com.xlab.tools.algorithm.tree.TreeNode;

/**
 * <p>
 * 树的先关测试
 *     7
 *    5  10
 *  2  6 8 15
 * </p>
 * @author towan  
 */
public class TreeTraveresalTest {
    
    private TreeNode createRootNode() {
        TreeNode root = new TreeNode(7);
        TreeNode l1 = new TreeNode(5);
        root.left = l1;
        l1.left = new TreeNode(2);
        l1.right = new TreeNode(6);
        
        TreeNode r1 = new TreeNode(10);
        root.right = r1;
        r1.left = new TreeNode(8);
        r1.right = new TreeNode(15);
        return root;
    }
    
    @Test
    public void test_Pre() {// pre:7,5,2,6,10,8,15
        TreeNode root = createRootNode();
        TreeTraversal traver = new TreeTraversal();
        traver.preOrderRec(root);
        System.out.println();
        traver.preOrderStack_1(root);
        
        System.out.println();
        traver.preOrderStack_2(root);
        
    }

    @Test
    public void test_mid() { // mid:2,5,6,7,8,10,15
        TreeNode root = createRootNode();
        TreeTraversal traver = new TreeTraversal();
        traver.inOrderStack(root);
        
        root = createRootNode();
        System.out.println();
        traver.inOrderRec(root);
        
    }

    @Test
    public void test_post() { // post:2,6,5,8,15,10,7
        TreeNode root = createRootNode();
        TreeTraversal traver = new TreeTraversal();
        traver.postOrderRec(root);
        System.out.println();
        traver.postOrderStack(root);
        
    }
    

    @Test
    public void test_layer() {   //layer:7,5,10,2,6,8,15
        TreeNode root = createRootNode();
        TreeTraversal traver = new TreeTraversal();
        traver.levelTravel(root);
        
    }
    

}
