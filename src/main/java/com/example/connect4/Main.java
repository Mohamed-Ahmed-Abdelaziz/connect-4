package com.example.connect4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void print(TreeNode node, String indent){
        node.state.board.printBoard(indent);
        System.out.println(indent + node.state.heuristic);
    }
    public static void printTree(TreeNode node, int k){
        String indent = "";
        for (int i = 0; i < k; i++) {
            indent += " ";
        }
        if (node == null){
            return;
        }
        print(node, indent);
        for (int i = 0; i < node.children.size(); i++) {
            printTree(node.children.get(i), k + 1);
        }
    }
    public static void main(String[] args){
        Board board = new Board();
        State state = new State(board);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Test by Hassan
//        board.play(2);
//        board.play(3);
//        board.play(2);
//        MiniMaxTree tree = new MiniMaxTree(state, 2);
//        TreeNode node = tree.miniMax(tree.root, 2, true);
//        printTree(node,0);
//        System.out.println("Best = " + tree.bestMove);


        while (!board.isFull()){
            System.out.println("Turn = " + board.turn);
            int input = scanner.nextInt();
            if(input == 10){
                break;
            }
            if(!board.play(input)){
                continue;
            };
            board.printBoard();
            System.out.println("Turn = " + board.turn);
            MiniMaxTree tree = new MiniMaxTree(state, 2);
            TreeNode node = tree.miniMax(tree.root, 2, true);
            int x = tree.bestMove;
            if(x == -1){
                System.out.println("No move");
            }else {
                board.play(x);
                board.printBoard();
            }

        }
//        System.out.println("Player = " + board.countPoints(2));
//        System.out.println("PC = " + board.countPoints(1));
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
