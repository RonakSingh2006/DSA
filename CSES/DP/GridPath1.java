import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GridPath1 {

  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    char grid[][] = new char[n][n];
    for(int i=0 ; i<n ; i++){
      grid[i] = br.readLine().toCharArray();
    }

    if(grid[0][0] == '*' || grid[n-1][n-1] == '*'){
      System.out.println(0);
      return;
    }

    long dp[][] = new long[n+1][n+1];
    dp[n-1][n-1] = 1;


    for(int r=n-1 ; r>=0 ; r--){
      for(int c=n-1 ; c>=0 ; c--){
        if(r==n-1 && c==n-1) continue;

        if(grid[r][c] != '*'){
          dp[r][c] = (dp[r+1][c] + dp[r][c+1])%MOD;
        }

      }
    }
  

    System.out.println(dp[0][0]);
  }
}
