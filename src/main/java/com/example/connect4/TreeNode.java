package com.example.connect4;

public class TreeNode {
    State state;
    boolean isMax;
    TreeNode[] children;
    TreeNode parent;

    public TreeNode(State state, TreeNode parent, boolean isMax) {
        this.state = state;
        this.parent = parent;
        this.isMax = isMax;
    }

    private TreeNode[] getChildren(){
        TreeNode[] children = new TreeNode[7];
        State[] nextStates = this.state.getNeighbours();
        for (int i = 0; i < 7; i++) {
            children[i] = new TreeNode(nextStates[i], this, !this.isMax);;
        }
        this.children = children;
        return children;
    }
}
