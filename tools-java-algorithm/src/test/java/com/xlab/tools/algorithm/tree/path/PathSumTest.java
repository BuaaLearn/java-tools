package com.xlab.tools.algorithm.tree.path;


import java.util.List;

import org.junit.Test;

import com.xlab.tools.algorithm.tree.TreeNode;

public class PathSumTest {

    @Test
    public void testPathSum() {
        int sum = 22;
        PathSum pathSum = new PathSum();
        TreeNode root = createTree();
        List<List<TreeNode>> pathSum2 = pathSum.pathSum(root, sum);
        for(List<TreeNode> path:pathSum2){
            System.out.println("cur-path:");
            for(TreeNode node:path){
                System.out.print(node.value+"\t");
            }
            
        }
    }

    /**
     * @return
     */
    private TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        TreeNode treeNode = new TreeNode(5);
        root.left = treeNode;
        
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(7);
        
        root.right = new TreeNode(12);
        return root;
    }

}
