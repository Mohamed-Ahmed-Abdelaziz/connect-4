package com.example.connect4;

public class MiniMaxTree {
    private TreeNode root;
    private boolean isCalculated;
    private int depth;
    // Constructor
    public MiniMaxTree(State state, int depth) {
        this.depth = depth;
        this.root = new TreeNode(state, null, true); // Assume starting as Max player
    }

    // MiniMax algorithm
    public TreeNode miniMax(TreeNode node, int depth, boolean maximizingPlayer) {
        isCalculated = true;
        if (depth == 0 || node.state.board.isFull()) {
            return node; // Evaluate the heuristic value for the current state
        }

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (TreeNode child : node.getChildren()) {
                int eval = miniMax(child, depth - 1, false).state.heuristic;
                maxEval = Math.max(maxEval, eval);
            }
            node.state.heuristic = maxEval;
            return node;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (TreeNode child : node.getChildren()) {
                int eval = miniMax(child, depth - 1, true).state.heuristic;
                minEval = Math.min(minEval, eval);
            }
            node.state.heuristic = minEval;
            return node;
        }
    }
    public int bestMove(){
        if(!isCalculated){
            this.root = miniMax(root, depth, true);
        }
        TreeNode[] children = root.getChildren();
        int bestMove = -1;
        int bestValue = Integer.MIN_VALUE;

        for (int i = 0; i < children.length; i++) {
            int currentValue = miniMax(children[i], this.depth, false).state.heuristic;
            if (currentValue > bestValue) {
                bestValue = currentValue;
                bestMove = i;
            }
        }
        return bestMove;
    }
    // Method to find the best move using MiniMax
//    public int findBestMove() {
//        TreeNode[] children = root.getChildren();
//        int bestMove = -1;
//        int bestValue = Integer.MIN_VALUE;
//
//        for (int i = 0; i < children.length; i++) {
//            int currentValue = miniMax(children[i], /* Choose a suitable depth */, false);
//            if (currentValue > bestValue) {
//                bestValue = currentValue;
//                bestMove = i;
//            }
//        }
//
//        return bestMove;
//    }

}
