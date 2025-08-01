package recursion;


public class NQueens2 {
    public static int solveNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        return place(board, 0, 0, n);
    }
    public static int place(boolean board[][] , int i , int j , int count){
        if(count == 0){
            return 1;
        }
        if(j==board.length || i==board.length){
            return 0;
        }
        int ans = 0;
        if(isSafe(i,j,board)){
            // place
            board[i][j] = true;
            ans += place(board, i+1, 0, count-1);
            board[i][j] = false;
        }
        ans += place(board, i, j+1, count);
        return ans;
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
    public static void main(String[] args) {
        int n = 10;
        
        System.out.println(solveNQueens(n));
    }
}
