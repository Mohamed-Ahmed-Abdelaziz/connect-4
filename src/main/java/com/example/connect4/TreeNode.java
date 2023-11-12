package com.example.connect4;

public class TreeNode {
    int heuristic;
    TreeNode[] children;
    TreeNode parent;

    TreeNode(int heuristic, TreeNode[] children, TreeNode parent) {
        this.heuristic = heuristic;
        this.children = children;
        this.parent = parent;
    }
}
