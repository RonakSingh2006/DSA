package recursion;
public class maze {
    public static void path(int maze[][]){
        solve(maze,"",0,0);
    }
    public static void solve(int maze[][] , String s , int posX , int posY){
        if(posX == maze[0].length-1 && posY == maze.length-1){
            System.out.println(s);
            return;
        }
        if(posX < maze[0].length){
            solve(maze,s+"R",posX+1,posY);
        }
        if(posY < maze.length){
            solve(maze,s+"D",posX,posY+1);
        }
    }
    public static int uniquePaths(int m, int n) {
        if(m==1 && n==1){
            return 1;
        }

        int left = 0, up = 0;
        if(m>1) left = uniquePaths(m-1,n);
        if(n>1) up = uniquePaths(m,n-1);

        return left+ up;
    }
    public static void main(String[] args) {
        int a[][] = new int[3][4];
        path(a);

        System.out.println(uniquePaths(3, 7));
    }
}
