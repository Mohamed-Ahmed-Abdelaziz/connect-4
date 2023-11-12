package com.example.connect4;

public class Board {
    Column[] columns;
    int turn;

    public Board(){
        this.columns = new Column[7];
        for(int i = 0; i < 7; i++){
            columns[i] = new Column();
        }
        this.turn = 2;
    }
    public Board clone(){
        Board copy = new Board();
        copy.turn = this.turn;
        for (int i = 0; i < this.columns.length; i++) {
            copy.columns[i] = this.columns[i].clone();
        }
        return copy;
    }
    public boolean play(int columnNum){
        if(columns[columnNum].add(turn)){
            if(turn == 1)
                turn = 2;
            else
                turn = 1;
            return true;
        }
        else{
            System.out.println("play in an available col");
            return false;
        }
    }

    public int countPoints(int player) {
        int rows = 6;
        int cols = 7;
        int count = 0;

        // Check horizontally
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (columns[j].get(i) == player &&
                        columns[j + 1].get(i) == player &&
                        columns[j + 2].get(i) == player &&
                        columns[j + 3].get(i) == player) {
                    count++;
                }
            }
        }
        //System.out.println("h " + count);

        // Check vertically
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j < cols; j++) {
                if (columns[j].get(i) == player &&
                        columns[j].get(i + 1) == player &&
                        columns[j].get(i + 2) == player &&
                        columns[j].get(i + 3) == player) {
                    count++;
                }
            }
        }
        //System.out.println("v " + count);

        // Check diagonally (positive slope)
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (columns[j].get(i) == player &&
                        columns[j + 1].get(i + 1) == player &&
                        columns[j + 2].get(i + 2) == player &&
                        columns[j + 3].get(i + 3) == player) {
                    count++;
                }
            }
        }
        //System.out.println("p " + count);

        // Check diagonally (negative slope)
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 3; j < cols; j++) {
                if (columns[j].get(i) == player &&
                        columns[j - 1].get(i + 1) == player &&
                        columns[j - 2].get(i + 2) == player &&
                        columns[j - 3].get(i + 3) == player) {
                    count++;
                }
            }
        }
        //System.out.println("n " + count);

        return count;
    }

    public Boolean isFull(){
        int fullColumnsCount = 0;
        for(int i = 0; i < 7; i++){
            if(columns[i].isFilled())
                fullColumnsCount++;
        }
        if (fullColumnsCount == 7)
            return true;
        else
            return false;
    }
    public void printBoard(){
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j < 7;j++){
                System.out.print(columns[j].get(i) + " ");
            }
            System.out.println();
        }
    }
}
