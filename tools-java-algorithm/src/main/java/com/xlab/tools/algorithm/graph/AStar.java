/*
 * Copyright 创新工作X实验室  @ 2017 版权所有
 */
package com.xlab.tools.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Astar算法，0表示可以通行，1表示障碍物。
 * 通过A*寻路算法找到以路径为@所示
 * </p>
 * @author towan  
 */
public class AStar {
    
    private   int[][] nodes ;//原始图
    
    static final int STEP = 10;
    private List<Node> openList = new ArrayList<>();
    private List<Node> closeList = new ArrayList<>();
    
    public AStar(int[][] nodes) {
        super();
        this.nodes = nodes;
    }
    
    /**
     * 查找F函数最小的节点
     * @return
     */
    private Node findMinFNodeInOpneList() {
        Node tempNode = openList.get(0);
        for (Node node : openList) {
            if (node.F < tempNode.F) {
                tempNode = node;
            }
        }
        return tempNode;
    }
    
    /**
     * 查找临近的节点
     * @param currentNode 当前节点
     * @return
     */
    private List<Node> findNeighborNodes(Node currentNode) {
        List<Node> arrayList = new ArrayList<Node>();
        // 只考虑上下左右，不考虑斜对角
        int topX = currentNode.x;
        int topY = currentNode.y - 1;
        if (canReach(topX, topY) && !exists(closeList, topX, topY)) {
            arrayList.add(new Node(topX, topY));
        }
        int bottomX = currentNode.x;
        int bottomY = currentNode.y + 1;
        if (canReach(bottomX, bottomY) && !exists(closeList, bottomX, bottomY)) {
            arrayList.add(new Node(bottomX, bottomY));
        }
        int leftX = currentNode.x - 1;
        int leftY = currentNode.y;
        if (canReach(leftX, leftY) && !exists(closeList, leftX, leftY)) {
            arrayList.add(new Node(leftX, leftY));
        }
        int rightX = currentNode.x + 1;
        int rightY = currentNode.y;
        if (canReach(rightX, rightY) && !exists(closeList, rightX, rightY)) {
            arrayList.add(new Node(rightX, rightY));
        }
        return arrayList;
    }
    
    /**
     * 是否可以到达
     * @param x
     * @param y
     * @return
     */
    private boolean canReach(int x, int y) {
        if (x >= 0 && x < nodes.length && y >= 0 && y < nodes[0].length) {
            return nodes[x][y] == 0;
        }
        return false;
    }
    
    /**
     * 查找起点和终点的路径
     * @param startNode
     * @param endNode
     * @return
     */
    public Node findPath(Node startNode, Node endNode) {
        // 把起点加入 open list
        openList.add(startNode);

        while (openList.size() > 0) {
            // 遍历 open list ，查找 F值最小的节点，把它作为当前要处理的节点
            Node currentNode = findMinFNodeInOpneList();
            // 从open list中移除
            openList.remove(currentNode);
            // 把这个节点移到 close list
            closeList.add(currentNode);

           List<Node> neighborNodes = findNeighborNodes(currentNode);
            for (Node node : neighborNodes) {
                if (exists(openList, node)) {
                    foundPoint(currentNode, node);
                } else {
                    notFoundPoint(currentNode, endNode, node);
                }
            }
            
            if (find(openList, endNode) != null) {
                return find(openList, endNode);
            }
        }

        return find(openList, endNode);
    }

    private void foundPoint(Node tempStart, Node node) {
        int G = calcG(tempStart, node);
        if (G < node.G) {
            node.parent = tempStart;
            node.G = G;
            node.calcF();
        }
    }

    private void notFoundPoint(Node tempStart, Node end, Node node) {
        node.parent = tempStart;
        node.G = calcG(tempStart, node);
        node.H = calcH(end, node);
        node.calcF();
        openList.add(node);
    }
    
    // 计算开始到当前的损失
    private int calcG(Node start, Node node) {
        int G = STEP;
        int parentG = node.parent != null ? node.parent.G : 0;
        return G + parentG;
    }
    
    // 曼哈顿方式探索
    private int calcH(Node end, Node node) {
        int step = Math.abs(node.x - end.x) + Math.abs(node.y - end.y);
        return step * STEP;
    }

    private static Node find(List<Node> nodes, Node point) {
        for (Node n : nodes)
            if ((n.x == point.x) && (n.y == point.y)) {
                return n;
            }
        return null;
    }

    private  boolean exists(List<Node> nodes, Node node) {
        for (Node n : nodes) {
            if ((n.x == node.x) && (n.y == node.y)) {
                return true;
            }
        }
        return false;
    }

    protected  boolean exists(List<Node> nodes, int x, int y) {
        for (Node n : nodes) {
            if ((n.x == x) && (n.y == y)) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int x;//x坐标
        private int y;//y坐标

        private int F;//计算探索损失
        private int G;//计算开始节点到当前节点的损失
        private int H;//计算当前节点到终止节点的损失
        
        // 计算f函数值
        public void calcF() {
            this.F = this.G + this.H;
        }
        
        //上一个节点
        public Node parent;
        

        /**
         * @return the x
         */
        public int getX() {
            return x;
        }

        /**
         * @param x the x to set
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * @return the y
         */
        public int getY() {
            return y;
        }

        /**
         * @param y the y to set
         */
        public void setY(int y) {
            this.y = y;
        }
        
        
        
    }
}
