package com.example.connect4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private int[][] board = new int[ROWS][COLUMNS];
    private boolean playerTurn = true;

    @Override
    public void start(Stage primaryStage) {
        initializeBoard();

        GridPane gridPane = createGameBoard();
//        addButtons(gridPane);

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setTitle("Connect 4 Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = 0;
            }
        }
//        board[0][0] = 1;
//        board[5][6] = 2;
    }

    private GridPane createGameBoard() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        Button[][] grd = new Button[6][7];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Button cell = new Button();

//                cell.setId(Integer.toString(i) + Integer.toString(j));
//                cell.getId();
                cell.setShape(new Circle(1.5));
                if(board[i][j] == 0)
                    cell.setStyle("-fx-background-color: grey");
                else if(board[i][j] == 1)
                    cell.setStyle("-fx-background-color: orangered");
                else
                    cell.setStyle("-fx-background-color: MediumSeaGreen");
//                cell.setStyle("-fx-background-color: grey");
//                cell.setStyle("-fx-background-color: MediumSeaGreen");
//                cell.setStyle("-fx-background-color: orangered");
//                bt.setMaxSize(3,3);
                cell.setMinSize(50, 50);
                int finalI = i;
                int finalJ = j;
                cell.setOnAction(e -> handleButtonClick(finalI, finalJ, grd));

                grd[i][j] = cell;
                gridPane.add(cell, j, i);
            }
        }
        return gridPane;
    }

    private void addButtons(GridPane gridPane) {
        for (int i = 0; i < COLUMNS; i++) {
            Button button = new Button("Drop");
            int finalI = i;
            button.setOnAction(e -> handleDropButtonClick(finalI));
            gridPane.add(button, i, ROWS);
        }
    }

    private void handleButtonClick(int row, int col, Button[][] grd) {
//        grd[row][col].setStyle("-fx-background-color: Blue");
        if(board[0][col] != 0) return;
        if(playerTurn == true) {
            for (int i = 5; i >= 0; --i) {
                if (board[i][col] == 0) {
                    board[i][col] = 1;
                    grd[i][col].setStyle("-fx-background-color: orangered");
                    break;
                }
            }
        }else{
            for (int i = 5; i >= 0; --i) {
                if (board[i][col] == 0) {
                    board[i][col] = 1;
                    grd[i][col].setStyle("-fx-background-color: MediumSeaGreen");
                    break;
                }
            }
        }
        playerTurn = !playerTurn;
        System.out.println("folaaaa");
//        start(new Stage());
    }

    private void handleDropButtonClick(int col) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}