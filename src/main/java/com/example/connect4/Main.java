package com.example.connect4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        State state = new State(board);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (!board.isFull()){
            System.out.println("Player number: " + board.turn);
            int input = scanner.nextInt();
            if(input == 10){
                break;
            }
            board.play(input);
            state.evaluateBoard(board, 1);
            MiniMaxTreeWithPruning tree = new MiniMaxTreeWithPruning(state, 4);
            int x = tree.bestMove();
            if(x == -1){
                System.out.println("No move");
            }else {
                System.out.println("Best Move = " + x);
                board.play(x);
                board.printBoard();
            }

        }
        System.out.println("Player = " + board.countPoints(2));
        System.out.println("PC = " + board.countPoints(1));
//        board.play(0);
//        board.play(1);
//        board.play(1);
//        board.play(1);
//        board.play(2);
//        board.play(2);
//        board.play(2);
//        board.play(3);
//        board.play(3);
//        board.play(3);
//        board.play(3);
//        board.play(4);
//        board.play(4);
//        board.play(4);
//        board.play(4);
//        board.play(5);
//        board.play(4);
//        board.play(5);
//        board.play(5);
//        board.play(5);
//        board.play(5);
//        board.play(6);
//        board.play(5);
//        board.play(0);
//        board.play(0);
//        board.play(0);
////        board.play(4);
////        board.play(4);
////        board.play(4);
////        board.play(4);
////        board.play(4);
////        board.play(4);
////        board.play(5);
////        board.play(5);
////        board.play(5);
////        board.play(5);
////        board.play(5);
////        board.play(5);
////        board.play(6);
////        board.play(6);
////        board.play(6);
////        board.play(6);
////        board.play(6);
////        board.play(6);
//        board.printBoard();
//        System.out.println(board.countPoints(2));
//        System.out.println(board.countPoints(1));
    }
}
