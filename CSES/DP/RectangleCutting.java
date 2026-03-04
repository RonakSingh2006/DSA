import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RectangleCutting {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ab[] = br.readLine().split(" ");
    int a = Integer.parseInt(ab[0]);
    int b = Integer.parseInt(ab[1]);

    long dp[][] = new long[a+1][b+1];
    for(long d[] : dp) Arrays.fill(d,Integer.MAX_VALUE);

    for(int i=1 ; i<=Math.min(a,b) ; i++){
      dp[i][i] = 0;
    }

    for(int i=1 ; i<=a ; i++){
      for(int j=1 ; j<=b ; j++){
        // cut a
        for(int k=1 ; k<i ; k++){
          dp[i][j] = Math.min(dp[i][j], 1 + dp[i-k][j] + dp[k][j]);
        }

        for(int k=1 ; k<j ; k++){
          dp[i][j] = Math.min(dp[i][j],1 + dp[i][j-k] + dp[i][k]);
        }
      }
    }

    System.out.println(dp[a][b]);
  }
}
