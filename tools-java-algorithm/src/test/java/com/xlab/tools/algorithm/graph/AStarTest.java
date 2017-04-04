package com.xlab.tools.algorithm.graph;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xlab.tools.algorithm.graph.AStar.Node;

public class AStarTest {

    @Test
    public void test() {
        // 原始图
        int[][] nodes =
                { {0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, 
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        // 开始节点
        Node startNode = new Node(5, 1);
        //结束节点
        Node endNode = new Node(5, 5);
        
        AStar aStar = new AStar(nodes);
        
        // A*搜索路径
        Node parent = aStar.findPath(startNode, endNode);
        
        //原始图
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                System.out.print(nodes[i][j] + ", ");
            }
            System.out.println();
        }
        
        List<Node> arrayList = new ArrayList<>();

        while (parent != null) {
            // System.out.println(parent.x + ", " + parent.y);
            arrayList.add(new Node(parent.getX(), parent.getY()));
            parent = parent.parent;
        }
        System.out.println("\n");

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                if (aStar.exists(arrayList, i, j)) {
                    System.out.print("@, ");
                } else {
                    System.out.print(nodes[i][j] + ", ");
                }

            }
            System.out.println();
        }

    }

}
