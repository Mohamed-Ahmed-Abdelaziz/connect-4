package com.example.connect4;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.play(0);
        board.play(1);
        board.play(1);
        board.play(1);
        board.play(2);
        board.play(2);
        board.play(2);
        board.play(3);
        board.play(3);
        board.play(3);
        board.play(3);
        board.play(4);
        board.play(4);
        board.play(4);
        board.play(4);
        board.play(5);
        board.play(4);
        board.play(5);
        board.play(5);
        board.play(5);
        board.play(5);
        board.play(6);
        board.play(5);
        board.play(0);
        board.play(0);
        board.play(0);
//        board.play(4);
//        board.play(4);
//        board.play(4);
//        board.play(4);
//        board.play(4);
//        board.play(4);
//        board.play(5);
//        board.play(5);
//        board.play(5);
//        board.play(5);
//        board.play(5);
//        board.play(5);
//        board.play(6);
//        board.play(6);
//        board.play(6);
//        board.play(6);
//        board.play(6);
//        board.play(6);
        board.printBoard();
        System.out.println(board.countPoints(2));
        System.out.println(board.countPoints(1));
    }
}
