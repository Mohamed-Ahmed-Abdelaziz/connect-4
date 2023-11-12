package com.example.connect4;

public class State {
    Board board;
    int heuristic;
    public State(Board board){
        this.board = board;
        this.heuristic = evaluateBoard(board, board.turn);
    }
    public State[] getNeighbours(){
        State[] neighbours = new State[7];
        for (int i = 0; i < 7; i++) {
            Board next = this.board.clone();
            Boolean isNext = next.play(i);
            if(isNext){
                neighbours[i] = new State(next);
            }else {
                neighbours[i] = null;
            }
        }
        return neighbours;
    }
    public  int evaluateBoard(Board board, int player) {
        int score = 0;

        // Check for horizontal connections
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                score += evaluateLine(board.columns[col].get(row), board.columns[col+1].get(row), board.columns[col+2].get(row), board.columns[col+3].get(row), player);
            }
        }

        // Check for vertical connections
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 7; col++) {
                score += evaluateLine(board.columns[col].get(row), board.columns[col].get(row+1), board.columns[col].get(row+2), board.columns[col].get(row+3), player);
            }
        }

        // Check for diagonal connections (from bottom-left to top-right)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                score += evaluateLine(board.columns[col].get(row), board.columns[col+1].get(row-1), board.columns[col+2].get(row-2), board.columns[col+3].get(row-3), player);
            }
        }

        // Check for diagonal connections (from top-left to bottom-right)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                score += evaluateLine(board.columns[col].get(row), board.columns[col+1].get(row+1), board.columns[col+2].get(row+2), board.columns[col+3].get(row+3), player);
            }
        }

        return score;
    }

    private int evaluateLine(int a, int b, int c, int d, int player) {
        int score = 0;
        int playerCount = 0;
        int opponentCount = 0;

        // Count the number of player and opponent discs in the line
        if (a == player) playerCount++;
        else if (a != 0) opponentCount++;

        if (b == player) playerCount++;
        else if (b != 0) opponentCount++;

        if (c == player) playerCount++;
        else if (c != 0) opponentCount++;

        if (d == player) playerCount++;
        else if (d != 0) opponentCount++;

        // Assign scores based on the number of player and opponent discs
        if (playerCount == 4) score += 1000;  // Player has four in a row
        else if (playerCount == 3 && opponentCount == 0) score += 100;  // Player has three in a row
        else if (playerCount == 2 && opponentCount == 0) score += 10;   // Player has two in a row
        else if (playerCount == 1 && opponentCount == 0) score += 1;    // Player has one in a row

        else if (opponentCount == 4) score -= 1000;  // Opponent has four in a row
        else if (opponentCount == 3 && playerCount == 0) score -= 100;  // Opponent has three in a row
        else if (opponentCount == 2 && playerCount == 0) score -= 10;   // Opponent has two in a row
        else if (opponentCount == 1 && playerCount == 0) score -= 1;    // Opponent has one in a row

        return score;
    }
}
