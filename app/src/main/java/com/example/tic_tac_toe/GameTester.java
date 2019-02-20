package com.example.tic_tac_toe;

public class GameTester {
    public static void main(String[] args){
        char winner = 'N';

        boolean check = false;

        char board[][]={
                {'O','X','X'},
                {'O','O','X'},
                {'X','O','X'},
        };
        for(int row = 0; !check && row < 3 && board[0][0] != '.'; row++){
            check = (board[row][0] == board[row][1]) && (board[row][0] == board[row][2]);
            winner = board[row][0];
        }
        for(int col = 0; !check && col < 3 && board[0][0] != '.'; col++){
            check = (board[0][col] == board[1][col]) && (board[0][col] == board[2][col]);
            winner = board[0][col];
        }
        if((check == false)&&((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) || (board[0][2] == board[1][1]) && (board[0][2] == board[2][0])) && board[1][1] != '.'){
            winner = board[1][1];
            check = true;
        }
        if(check){
            System.out.println(winner + " " + check);
        }
        else{
            System.out.println(check);
        }
    }
}
