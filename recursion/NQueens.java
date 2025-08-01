package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean board[][] = new boolean[n][n];
        place(board, 0, 0, n, ans);
        return ans;
    }
    public static void place(boolean board[][] , int i , int j , int count , List<List<String>> ans){
        if(count == 0){
            ans.add(decode(board));
            return;
        }
        if(j==board.length || i==board.length){
            return;
        }

        if(isSafe(i,j,board)){
            // place
            board[i][j] = true;
            place(board, i+1, 0, count-1,ans);
            board[i][j] = false;
        }
        place(board, i, j+1, count,ans);
    }
    public static boolean isSafe(int i , int j , boolean board[][]){

        // vertically
        for(int k=0 ; k<=i ; k++){
            if(board[k][j]) return false;
        }

        // Diagonal

        // left diagonal
        int up = i;
        int l = j;
        while(l>=0 && up>=0){
            if(board[up][l]) return false;
            up--;
            l--;
        }

        // right diagonal
        up = i;
        l = j;
        while(l<board.length && up>=0){
            if(board[up][l]) return false;
            up--;
            l++;
        }

        return true;
    }
    public static List<String> decode(boolean borad[][]){
        List<String> list = new ArrayList<>();
        for(boolean a[] : borad){
            StringBuilder sb = new StringBuilder();
            for(boolean x : a){
                if(x) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        return list;
    }
    public static void main(String[] args) {
        int n = 4;
        
        System.out.println(solveNQueens(n));
    }
}
