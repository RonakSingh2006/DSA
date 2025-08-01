package recursion;

import java.util.Arrays;

public class Suduko {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public boolean solve(char board[][] , int row , int col){
        int n = board.length;
        if(col == n){
            col = 0;
            row++;
        }

        if(row == n) return true;

        if(board[row][col] != '.'){
            if(solve(board,row,col+1)) return true;
            else return false;
        }
        else{
            for(char ch='1' ; ch<='9' ; ch++){
                if(valid(board,row,col,ch)){
                    board[row][col] = ch;

                    if(solve(board,row,col+1)) return true;
                    
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public boolean valid(char board[][] , int row , int col , char ch){
        int n = board.length;
        // vertically and horizontatlly
        for(int i=0 ; i<n ; i++){
            if(board[i][col] == ch) return false;
            if(board[row][i] == ch) return false;
        }       

        // in 3*3 block
        int r = row/3;
        int rowStart = r*3;
        int rowEnd = (r+1)*3 - 1;

        int c = col/3;
        int colStart = c*3;
        int colEnd = (c+1)*3 - 1;

        for(int i=rowStart ; i<=rowEnd ; i++){
            for(int j=colStart ; j<=colEnd ; j++){
                if(board[i][j] == ch) return false;
            }
        }

        return true;

    }
}

class SudukoMain{
    public static void main(String[] args) {
        char board[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        Suduko sud = new Suduko();
        sud.solveSudoku(board);

        for(char a[] : board){
            System.out.println(Arrays.toString(a));
        }
    }
}