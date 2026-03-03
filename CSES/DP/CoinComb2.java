import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CoinComb2 {

  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nk[] = br.readLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);

    String coinsS[] = br.readLine().split(" ");

    int coins[] = new int[n];
    for(int i=0 ; i<n ; i++){
      coins[i] = Integer.parseInt(coinsS[i]);
    }

    long dp[] = new long[k+1];
    dp[0] = 1;

    
    for(int c : coins){
      for(int sum=1 ; sum<=k ; sum++){
        if(c <= sum) dp[sum] = (dp[sum] + dp[sum-c])%MOD;
      }
    }
    
    System.out.println(dp[k]);
  }
}
