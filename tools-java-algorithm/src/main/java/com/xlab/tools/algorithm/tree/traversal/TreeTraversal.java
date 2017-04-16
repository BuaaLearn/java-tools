/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.tree.traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import com.xlab.tools.algorithm.tree.TreeNode;

/**
 * <p>
 * 树的相关遍历（递归的和非递归的方式)
 * </p>
 * @author towan  
 */

public class TreeTraversal {  
    
    /** 
     * @param root 树根节点 
     * 递归先序遍历 
     */  
    public void preOrderRec(TreeNode root){  
        if(root!=null){  
            System.out.print(root.value+"\t");  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
        }  
    }  
    
    /** 
     * @param root 树根节点 
     * 递归中序遍历 
     */  
    public void inOrderRec(TreeNode root){  
        if(root!=null){  
            preOrderRec(root.left);  
            System.out.print(root.value+"\t");  
            preOrderRec(root.right);  
        }  
    }  
    
    /** 
     * @param root 树根节点 
     * 递归后序遍历 
     */  
    public void postOrderRec(TreeNode root){  
        if(root!=null){  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
            System.out.println(root.value);  
        }  
    }  
    
    /** 
     *  
     * @param root 树根节点 
     * 利用栈实现循环先序遍历二叉树 
     * 这种实现类似于图的深度优先遍历（DFS） 
     * 维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。 
     * 这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用 
     */  
    public void preOrderStack_1(TreeNode root){  
        if(root==null)return;  
        Stack<TreeNode> s=new Stack<TreeNode>();  
        s.push(root);  
        while(!s.isEmpty()){  
            TreeNode temp=s.pop();  
            System.out.print(temp.value+"\t");  
            
            if(temp.right!=null) {//利用栈先右边，后左边
                s.push(temp.right);  
            }
            
            if(temp.left!=null) {
                s.push(temp.left);  
            }
        }  
    }  
    /** 
     *  
     * @param root 树的根节点 
     * 利用栈模拟递归过程实现循环先序遍历二叉树 
     * 这种方式具备扩展性，它模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树 
     */  
    public void preOrderStack_2(TreeNode root){  
        if(root==null){
            return;  
        }
        
        TreeNode p = root;//遍历节点
        Stack<TreeNode> s =new Stack<>();  
        while(p!=null || !s.isEmpty()){  
            
            while(p!=null){  
                System.out.print(p.value+"\t");  
                s.push(p);//先访问再入栈  
                p = p.left; 
            }  
            p = s.pop();  
            p = p.right;//如果是null，出栈并处理右子树  
        }  
        
    }  
    
    /** 
     *  
     * @param root 树根节点 
     * 利用栈模拟递归过程实现循环中序遍历二叉树 
     * 思想和上面的preOrderStack_2相同，只是访问的时间是在左子树都处理完直到null的时候出栈并访问。 
     */  
    public void inOrderStack(TreeNode root){  
        if(root == null){
            return;  
        }
        
        Stack<TreeNode> s = new Stack<>();  
        TreeNode p = root;
        while(p!=null || !s.isEmpty()){  
            while(p!=null){  
                s.push(p);//先访问再入栈  
                p = p.left;  
            }  
            p = s.pop();  
            System.out.print(p.value+"\t");  
            p = p.right;//如果是null，出栈并处理右子树  
        }  
    }  
    
    /** 
     *  
     * @param root 树根节点 
     * 后序遍历不同于先序和中序，它是要先处理完左右子树，然后再处理根(回溯)，所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，这里可以用map实现 
     */  
    public void postOrderStack(TreeNode root){  
        
        if(root==null){
            return;  
        }
        
        Stack<TreeNode> s = new Stack<>();  
        Map<TreeNode,Boolean> map = new HashMap<>();   
        s.push(root);  
        
        while(!s.isEmpty()){  
            TreeNode temp = s.peek();  
            if(temp.left!=null&&!map.containsKey(temp.left)){  
                temp = temp.left;  
                
                while(temp!=null){  
                    if(map.containsKey(temp)){
                        break;  
                    }else {
                        s.push(temp);  
                    }
                    temp=temp.left;  
                }  
                continue;  
            }  
            if(temp.right!=null && !map.containsKey(temp.right)){  
                s.push(temp.right);  
                continue;  
            }  
            
            TreeNode t = s.pop();  
            map.put(t,true);  
            System.out.print(t.value+"\t");  
        }  
    } 
    
    /** 
     *  
     * @param root 树根节点 
     * 层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着讲访问节点的左右子树依次入队列 
     */  
    public void levelTravel(TreeNode root){  
        if(root==null){
            return;  
        }
        Queue<TreeNode> q = new LinkedList<>();  
        q.add(root);//加入当前叶子节点
        
        while(!q.isEmpty()){  
            TreeNode temp =  q.poll();  
            System.out.print(temp.value+"\t");  
            
            //加入左边
            if(temp.left!=null){
                q.add(temp.left);  
            }
            //加入右边
            if(temp.right!=null){
                q.add(temp.right);  
            }
        }  
    }  
}  