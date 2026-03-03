import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceComb {
  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    long dp[] = new long[n+1];
    dp[0] = 1;

    for(int i=1 ; i<=n ; i++){
      long ans = 0;

      for(int d=1 ; d<=Math.min(i,6) ; d++){
        ans = (ans + dp[i-d])%MOD;
      }

      dp[i] = ans;
    }

    System.out.println(dp[n]);
  }
}
