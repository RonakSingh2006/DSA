import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinCoin {
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
    Arrays.fill(dp,Integer.MAX_VALUE);
    
    dp[0] = 0;

    for(int i=1 ; i<=k ; i++){
      for(int c : coins){
        if(c<=i){
          dp[i] = Math.min(dp[i],1 + dp[i-c]);
        }
      }
    }

    System.out.println(dp[k] >= Integer.MAX_VALUE ? -1 : dp[k]);
  }
}
