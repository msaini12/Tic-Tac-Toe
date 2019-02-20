package com.example.tic_tac_toe;

public class Game {
    char[][] board;
    String nameX, nameO, first, row, col, errorMsg;
    int counter = 0;
    char winner = 'N';
    boolean over = false;
    boolean error;

    Game(String nameX, String nameO, String first){
        this.nameX = nameX;
        this.nameO = nameO;
        this.first = first;
        this.board = new char[3][3];
        error = false;
        errorMsg = "";
    }

    void setRC(String row, String col){
        this.row = row;
        this.col = col;
        error = false;
        errorMsg = "";
    }
    void setError(String errorMsg){
        this.error = true;
        this.errorMsg = errorMsg;
    }

    void resetError(){
        this.error = false;
        this.errorMsg = "";
    }
    boolean checkTieGame(){
        boolean check = true;
        for(int row = 0; check && row < 3; row++){
            for(int col = 0; check && col < 3; col++){
                check = board[row][col] != '\u0000';
            }
        }
        return check;
    }
    String Turn(){
        String turn = "";
        if(counter == 0){
            if(first.equals("Player X")){
                turn = nameX;
                counter = 1;
            }
            else if(first.equals("Player O")){
                turn = nameO;
                counter = 2;
            }
        }
        else if(counter % 2 != 0){
            turn = nameX;
            counter++;
        }
        else if(counter % 2 == 0){
            turn = nameO;
            counter++;
        }
        return turn;
    }

    String getGame(){
        this.counter = 0;
        String s;
        String turn = Turn();
        s = board();
        s += "Next player to play: " + turn;
        return s;
    }

    String board(){
        String s = "";
        s += "Current Game Status:\n";
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(board[row][col] == '\u0000'){
                    s += ".";
                }
                else{
                    s += board[row][col];
                }
            }
            s += "\n";
        }
        return s;
    }

    boolean Winner(){
        boolean check = false;
        for(int row = 0; !check && row < 3; row++){
            check = (board[row][0] == board[row][1]) && (board[row][0] == board[row][2]) && board[row][0] != '\u0000';
            winner = board[row][0];
        }
        for(int col = 0; !check && col < 3; col++){
            check = (board[0][col] == board[1][col]) && (board[0][col] == board[2][col]) && board[0][col] != '\u0000';
            winner = board[0][col];
        }
        if((check == false)&&((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) || (board[0][2] == board[1][1]) && (board[0][2] == board[2][0])) && board[1][1] != '\u0000'){
            winner = board[1][1];
            check = true;
        }
        return check;
    }

    String getPlay(){
        String s = "";

        int row = Integer.parseInt(this.row);
        int col = Integer.parseInt(this.col);
        String turn = Turn();
        if(over){
            setError("Error: game is already over");
            s += errorMsg + "\n";
        }
        else{
            if(turn.equals(nameX)){
                if(this.board[row - 1][col - 1] == 'X' || this.board[row - 1][col - 1] == 'O'){
                    setError("Error: slot @ (" + row + "," + col + ") already occupied");
                    s += errorMsg + "\n";
                }
                else{
                    resetError();
                    this.board[row - 1][col - 1] = 'X';
                }
            }
            else if(turn.equals(nameO)){
                if(this.board[row - 1][col - 1] == 'X' || this.board[row - 1][col - 1] == 'O'){
                    setError("Error: slot @ (" + row + "," + col + ") already occupied");
                    s += errorMsg + "\n";
                }
                else{
                    resetError();
                    this.board[row - 1][col - 1] = 'O';
                }
            }
        }
        s += board();
        if(errorMsg.equals("")){
            if(turn.equals(nameX)){
                if(Winner() && winner == 'X'){
                    s += "Game is over with " + nameX + " being the winner";
                    over = true;
                }
                else if(Winner() && winner == 'O'){
                    s += "Game is over with " + nameO + " being the winner";
                    over = true;
                }
                else if(checkTieGame()){
                    s += "Game is over with a tie between " + nameX + " and " + nameO;
                    over = true;
                }
                else{
                    s += "Next player to play: " + nameO;
                }
            }
            else if(turn.equals(nameO)){
                if(Winner() && winner == 'X'){
                    s += "Game is over with " + nameX + " being the winner";
                    over = true;
                }
                else if(Winner() && winner == 'O'){
                    s += "Game is over with " + nameO + " being the winner";
                    over = true;
                }
                else if(checkTieGame()){
                    s += "Game is over with a tie between " + nameX + " and " + nameO;
                    over = true;
                }
                else{
                    s += "Next player to play: " + nameX;
                }
            }
        }
        else if(errorMsg.equals("Error: slot @ (" + row + "," + col + ") already occupied")){
            if(turn.equals(nameX)){
                s += "Next player to play: " + nameX;
                counter = 1;
            }
            else if(turn.equals(nameO)){
                s += "Next player to play: " + nameO;
                counter = 2;
            }
        }
        else{
            if(Winner() && winner == 'X'){
                s += "Game is over with " + nameX + " being the winner";
            }
            else if(checkTieGame()){
                s += "Game is over with a tie between " + nameX + " and " + nameO;
            }
            else{
                s += "Game is over with " + nameO + " being the winner";
            }
        }
        return s;
    }
}
