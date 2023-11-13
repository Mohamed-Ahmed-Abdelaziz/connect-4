package com.example.connect4;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    State state;
    boolean isMax;
    List<TreeNode> children;
    TreeNode parent;

    public TreeNode(State state, TreeNode parent, boolean isMax) {
        this.state = state;
        this.parent = parent;
        this.isMax = isMax;
        this.children = new ArrayList<>();
    }

    public List<TreeNode> getChildren(){
        List<TreeNode> children = new ArrayList<>();
        List<State> nextStates = this.state.getNeighbours();
        for (int i = 0; i < nextStates.size(); i++) {
            children.add(new TreeNode(nextStates.get(i), this, !this.isMax));
        }
        this.children = children;
        return children;
    }
}
