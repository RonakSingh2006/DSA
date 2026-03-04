import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayDescription {

  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nm[] = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    String inp[] = br.readLine().split(" ");
    int arr[] = new int[n];
    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(inp[i]);
    }

    long dp[][] = new long[n+1][m+2];

    for(int i=0 ; i<=m+1 ; i++){
      dp[n][i] = 1;
    }

    for(int idx = n-1 ; idx >= 0 ; idx--){
      for(int prev = 1 ; prev <= m+1 ; prev++){

        if(arr[idx] == 0){
          long ans = 0;
          if(prev == m+1){
            for(int i=1 ; i<=m ; i++){
              ans = (ans +  dp[idx+1][i])%MOD;
            }
          }
          else{
            for(int i=-1 ; i<=1 ; i++){
              int x = prev + i;

              if(x >= 1 && x <= m){
                ans = (ans +  dp[idx+1][x])%MOD;
              }
            }
          }

          dp[idx][prev] = ans;
        }
        else{
          if(prev == m+1 || Math.abs(arr[idx] - prev) <= 1){
            dp[idx][prev] = dp[idx+1][arr[idx]];
          }
        }
      }
    }

    System.out.println(dp[0][m+1]);
    
  }
}
