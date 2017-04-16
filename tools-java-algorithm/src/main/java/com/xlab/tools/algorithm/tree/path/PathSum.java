/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.tree.path;

import java.util.ArrayList;
import java.util.List;

import com.xlab.tools.algorithm.tree.TreeNode;

/**
 * <p>
 * 二叉树的节点的路径和：
 * 路径定义为根节点到叶子节点的路径
 * </p>
 * @author towan  
 */
public class PathSum {
    
    /**
     * 输出所有的路径和
     * @param root
     * @param sum
     */
    public List<List<TreeNode>> pathSum(TreeNode root, int sum){
       int curSum = 0;
       List<TreeNode> path = new ArrayList<>();
       
       List<List<TreeNode>> paths = new ArrayList<>();
       
       getPathSum(root, paths, path, curSum, sum);
       System.out.println("ret-size:"+paths.size()+",content:"+paths);
        return paths;
    }

    /**
     * 当前节点下获得路径和（前序遍历的方式）
     * @param curNode 当前节点
     * @param paths 总路径树
     * @param path 当前路径
     * @param curSum
     * @param sum
     */
    private void getPathSum(TreeNode curNode, List<List<TreeNode>> paths, List<TreeNode> path,
            int curSum, int sum) {
        //计算当前路径的节点和
        curSum += curNode.value;
        path.add(curNode);//相当于压入栈
        
        boolean isLeaf = curNode.left==null && curNode.right == null;
        if(isLeaf && curSum == sum){//加入当前路径
            paths.add(path);//记录总结果
            for(TreeNode node:path){
                System.out.print(node.value+"\t");
            }
            System.out.println();
        }
        
        //非叶子节点
        if(curNode.left!=null){
            getPathSum(curNode.left, paths, path, curSum, sum);
        }
        
        if(curNode.right!=null){
            getPathSum(curNode.right, paths, path, curSum, sum);
        }
        
        //当前节点去掉
        curSum -= curNode.value;
        
        path.remove(path.size()-1);//相当于栈的后进先出
    }

}
