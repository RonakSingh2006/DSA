import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class TwoSets2 {
  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    int n = Integer.parseInt(br.readLine());
 
    int sum = (n*(n+1))/2;
 
 
    if(sum%2 != 0){
      System.out.println(0);
      return;
    }
 
    sum/=2;
 
    long dp[][] = new long[n+2][sum+1];
 
    dp[n+1][0] = 1;
 
    for(int i=n ; i>=1 ; i--){
      for(int s=0 ; s<=sum ; s++){
        long take = (s >= i) ? dp[i+1][s-i] : 0;
        long noTake = dp[i+1][s];
 
        dp[i][s] = (take + noTake)%MOD;
      }
    }

    // We can't directly divide by 2 in case of MOD
    // we ahve to find MOD inverse of 2

    long inv2 = modInverse(2, MOD);
    System.out.println((dp[1][sum] * inv2) % MOD);
  }

  static long modPow(long a, long b, long mod){
    if(b == 0) return 1;

    long half = modPow(a, b/2, mod);
    long res = (half * half) % mod;

    if(b % 2 == 1)
        res = (res * a) % mod;

    return res;
  } 
  static long modInverse(long a, long mod){
      return modPow(a, mod - 2, mod);
  }
}
