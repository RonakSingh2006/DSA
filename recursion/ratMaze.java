package recursion;

class Solution {
    // 0->block 1->free
    // rat can move Left,Right,Up,Down

    public static void findPath(int mat[][] , String str , int i , int j) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        if(i==n-1 && j==m-1 && mat[i][j]==1){
            System.out.println(str);
            return;
        }

        if(i<0 || j<0 || i==n || j==m || mat[i][j] == 0) return;
        
        mat[i][j] = 0;
        
        findPath(mat, str+"L", i, j-1);
        findPath(mat, str+"R", i, j+1);
        findPath(mat, str+"U", i-1, j);
        findPath(mat, str+"D", i+1, j);
        
        mat[i][j] = 1;

    }
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0}, 
            {1, 0}
        };
        if(maze[0][0] == 0) return;
        findPath(maze,"",0,0);
    }
}